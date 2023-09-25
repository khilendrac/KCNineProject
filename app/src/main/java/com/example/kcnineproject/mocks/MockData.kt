package com.example.kcnineproject.mocks

import com.example.kcnineproject.data.RelatedAssetImage
import com.example.kcnineproject.data.Asset
import com.example.kcnineproject.data.Assets
import com.example.kcnineproject.data.Overrides


object MockData {
    // Mock data for RelatedImage
    private val relatedAssetImage = RelatedAssetImage(
        assetType = "image",
        authors = emptyList(),
        brands = emptyList(),
        categories = emptyList(),
        description = "An example related asset image",
        height = 800,
        id = 201,
        large = "",
        large2x = "",
        lastModified = 1678923456,
        photographer = "Alice Photographer",
        sponsored = false,
        thumbnail = "https://www.freecodecamp.org/news/content/images/size/w2000/2022/09/jonatan-pie-3l3RwQdHRHg-unsplash.jpg",
        thumbnail2x = "",
        timeStamp = 1678923456,
        type = "jpg",
        url = "https://www.freecodecamp.org/news",
        width = 1200,
        xLarge = "",
        xLarge2x = ""
    )

    // Mock data for Asset
    val asset = Asset(
        acceptComments = true,
        assetType = "",
        authors = listOf(),
        body = "",
        byLine = "John Doe",
        categories = listOf(),
        companies = listOf(),
        extendedAbstract = "",
        headline = "This is a headline",
        id = 123,
        indexHeadline = "",
        lastModified = System.currentTimeMillis(),
        legalStatus = "",
        live = true,
        liveArticleSummary = "",
        numberOfComments = 1,
        overrides = Overrides(
            overrideAbstract = "",
            overrideHeadline = ""
        ),
        relatedAssets = emptyList(),
        relatedImages = listOf(relatedAssetImage),
        relatedPosts = emptyList(),
        signPost = "",
        sources = listOf(),
        sponsored = false,
        tabletHeadline = "",
        theAbstract = "",
        timeStamp = System.currentTimeMillis(),
        url = "https://www.freecodecamp.org/news"
    )

    val assets = Assets(
        assetType = "news",
        assets = listOf(asset),
        authors = emptyList(),
        categories = emptyList(),
        displayName = "Latest News",
        id = 1,
        lastModified = 1678923456,
        onTime = 1678923456,
        relatedAssets = emptyList(),
        relatedImages = emptyList(),
        sponsored = false,
        timeStamp = 1678923456,
        url = ""
    )

}


