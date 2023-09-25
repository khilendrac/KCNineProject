package com.example.kcnineproject.ui.views

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage
import com.example.kcnineproject.data.RelatedAssetImage
import com.example.kcnineproject.utilities.Constants

/*
  Async Image from Coil automatically caches the loaded image on disk.
  It will not required to be reloaded if requested in the future.
*/

@Composable
fun ImageView(
    relatedAssetImage: List<RelatedAssetImage>,
    getSmallestImageUrl: (RelatedAssetImage) -> String? = { Constants.EMPTY_STRING },
) {
    if (relatedAssetImage.isNotEmpty()) {
        relatedAssetImage.first().let {
            AsyncImage(model = getSmallestImageUrl(it), contentDescription = it.description)
        }
    }

}

