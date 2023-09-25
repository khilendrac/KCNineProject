package com.example.kcnineproject.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AssetListConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromJson(json: String?): List<Asset> {
        if (json == null) return emptyList()

        val listType = object : TypeToken<List<Asset>>() {}.type
        return gson.fromJson(json, listType)
    }

    @TypeConverter
    fun toJson(list: List<Asset>): String {
        return gson.toJson(list)
    }
}
