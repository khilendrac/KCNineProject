package com.example.kcnineproject.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.kcnineproject.R

/*
This view is implemented when there is Error response from the Api.
 */
@Composable
fun ErrorView(errorMessage: String) {
    Box(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        contentAlignment = Alignment.Center
    ) {
        Text(errorMessage, fontWeight = FontWeight.ExtraBold)
    }
}

@Preview
@Composable
private fun ErrorViewPreview() {
    ErrorView(errorMessage = stringResource(R.string.something_went_wrong))
}