package com.example.kcnineproject.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Assets::class], version = 1)
@TypeConverters(AssetListConverter::class, AnyListConverter::class)
abstract class AssetsDatabase : RoomDatabase() {
    abstract fun assetsDao(): AssetsDao
}