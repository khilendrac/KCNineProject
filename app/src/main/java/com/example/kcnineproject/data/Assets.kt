package com.example.kcnineproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName

@Entity
@TypeConverters(AssetListConverter::class, AnyListConverter::class)
data class Assets(
    @PrimaryKey val id: Int,
    val assetType: String,
    val assets: List<Asset>,
    val authors: List<Any>,
    val categories: List<Any>,
    val displayName: String,
    val lastModified: Int,
    val onTime: Int,
    val relatedAssets: List<Any>,
    val relatedImages: List<Any>,
    val sponsored: Boolean,
    val timeStamp: Int,
    val url: String
)

data class Asset(
    val acceptComments: Boolean,
    val assetType: String,
    val authors: List<Author>,
    val body: String,
    val byLine: String,
    val categories: List<Category>,
    val companies: List<Company>,
    val extendedAbstract: String,
    val headline: String,
    val id: Int,
    val indexHeadline: String,
    val lastModified: Long,
    val legalStatus: String,
    val live: Boolean,
    val liveArticleSummary: String,
    val numberOfComments: Int,
    val overrides: Overrides,
    val relatedAssets: List<Any>,
    val relatedImages: List<RelatedAssetImage>,
    val relatedPosts: List<Any>,
    val signPost: String,
    val sources: List<Source>,
    val sponsored: Boolean,
    val tabletHeadline: String,
    val theAbstract: String,
    val timeStamp: Long,
    val url: String
)

data class Author(
    val email: String,
    val name: String,
    val relatedAssets: List<Any>,
    val relatedImages: List<RelatedImage>,
    val title: String
)

data class Category(
    val name: String,
    val orderNum: Int,
    val sectionPath: String
)

data class Company(
    val abbreviatedName: String,
    val companyCode: String,
    val companyName: String,
    val companyNumber: String,
    val exchange: String,
    val id: Int
)

data class Overrides(
    val overrideAbstract: String,
    val overrideHeadline: String
)

data class RelatedAssetImage(
    val assetType: String,
    val authors: List<Any>,
    val brands: List<Any>,
    val categories: List<Any>,
    val description: String,
    val height: Int,
    val id: Int,
    val large: String?,
    @SerializedName("large@2x")
    val large2x: String?,
    val lastModified: Int,
    val photographer: String,
    val sponsored: Boolean,
    val thumbnail: String?,
    @SerializedName("thumbnail@2x")
    val thumbnail2x: String?,
    val timeStamp: Int,
    val type: String,
    val url: String,
    val width: Int,
    val xLarge: String?,
    @SerializedName("xLarge@2x")
    val xLarge2x: String?
)

data class Source(
    val tagId: String
)

data class RelatedImage(
    val assetType: String,
    val authors: List<Any>,
    val brands: List<Any>,
    val categories: List<Any>,
    val description: String,
    val height: Int,
    val id: Int,
    val lastModified: Long,
    val photographer: String,
    val sponsored: Boolean,
    val timeStamp: Long,
    val type: String,
    val url: String,
    val width: Int
)