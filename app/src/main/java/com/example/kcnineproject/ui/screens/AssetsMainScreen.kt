package com.example.kcnineproject.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.kcnineproject.ui.views.AssetView
import com.example.kcnineproject.ui.views.ErrorView
import com.example.kcnineproject.utilities.UIState
import com.example.kcnineproject.viewmodels.AssetsViewModel

@Composable
fun AssetsMainScreen(viewModel: AssetsViewModel) {

    val uiState = viewModel.uiState.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        contentAlignment = Alignment.TopCenter
    ) {

        //The different kinds of views are displayed depending upon the uiState.
        when (uiState) {
            is UIState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(Modifier.testTag("Loading"))
                }
            }

            is UIState.Loaded -> {
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        items(uiState.assets) { asset ->
                            AssetView(
                                asset,
                                viewModel::getSmallestImageUrl,
                                testTag = "Article ${uiState.assets.indexOf(asset) + 1}"
                            )
                        }
                    }
                }
            }

            is UIState.Error -> {
                ErrorView(uiState.message)
            }
        }
    }
}