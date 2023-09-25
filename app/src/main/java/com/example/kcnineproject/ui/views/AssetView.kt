package com.example.kcnineproject.ui.views

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kcnineproject.data.Asset
import com.example.kcnineproject.data.RelatedAssetImage
import com.example.kcnineproject.mocks.MockData
import com.example.kcnineproject.utilities.Constants.EMPTY_STRING
import com.example.kcnineproject.utilities.getFormattedDate

/*
This view is for each individual news articles or cells.
 */
@Composable
fun AssetView(
    asset: Asset,
    getSmallestImageUrl: (RelatedAssetImage) -> String? = { EMPTY_STRING },
    testTag: String = EMPTY_STRING
) {

    val context = LocalContext.current

    Column(
        Modifier
            .testTag(testTag)
            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
            .fillMaxWidth()
            .clickable {
                //Using CustomTabsIntent because it is very useful in staying inside the application.
                CustomTabsIntent
                    .Builder()
                    .build()
                    .launchUrl(context, Uri.parse(asset.url))
            }
            .padding(5.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column {
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                Text(
                    asset.timeStamp.getFormattedDate(),
                    fontWeight = FontWeight.Light,
                    fontSize = 10.sp
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(asset.headline, fontWeight = FontWeight.ExtraBold)
                    Text(asset.theAbstract, textAlign = TextAlign.Justify)
                    Text(asset.byLine, fontStyle = FontStyle.Italic)
                }
            }
        }

        ImageView(asset.relatedImages, getSmallestImageUrl)
    }
}

@Preview
@Composable
private fun AssetViewPreview() {
    AssetView(
        asset = MockData.asset
    )
}
