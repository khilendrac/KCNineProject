package com.example.kcnineproject.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kcnineproject.data.AssetsRepository
import com.example.kcnineproject.data.RelatedAssetImage
import com.example.kcnineproject.utilities.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AssetsViewModel @Inject constructor(
    private val assetsRepository: AssetsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Loading)
    val uiState = _uiState.asStateFlow() //This is collected as state in UI.

    /*
    The advantage of using MutableStateFlow is that it has a smaller memory footprint,
    since it only stores a single value. It also provides a simpler and more concise API for managing
    single-value state
     */

    init {
        //Runs as soon as the view model instance is created.
        fetchAssets()
    }

    private fun fetchAssets() {

        //Initial state is set as loading.
        _uiState.value = UIState.Loading

        //Fetching the results from API at the background using coroutines.
        viewModelScope.launch {
            try {
                assetsRepository.getAssets().collect { assets ->
                    _uiState.value =
                        UIState.Loaded(assets.assets.sortedByDescending { it.timeStamp })
                }


            } catch (exception: Exception) {
                //Updating the UI state to error if there is any issue while getting response.
                _uiState.value = UIState.Error(
                    exception.localizedMessage ?: "Something went wrong"
                )
            }
        }
    }


    /**
    This function will return the smallest available image in order:
    1. thumbnail
    2. thumbnail2x
    3. large
    4. large2X
    5. xLarge
    6. xLarge2x
     */

    fun getSmallestImageUrl(image: RelatedAssetImage): String? {
        return listOf(
            image.thumbnail,
            image.thumbnail2x,
            image.large,
            image.large2x,
            image.xLarge,
            image.xLarge2x
        ).firstOrNull { it?.isNotEmpty() == true }
    }
}