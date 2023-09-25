package com.example.kcnineproject.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AnyListConverter {
    private val gson = Gson()

    @TypeConverter
    fun fromJson(json: String?): List<Any> {
        if (json == null) return emptyList()

        val listType = object : TypeToken<List<Any>>() {}.type
        return gson.fromJson(json, listType)
    }

    @TypeConverter
    fun toJson(list: List<Any>): String {
        return gson.toJson(list)
    }
}
