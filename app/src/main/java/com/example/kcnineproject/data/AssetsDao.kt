package com.example.kcnineproject.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface AssetsDao {
    @Query("SELECT * from Assets")
    fun getAssets(): Assets

    @Upsert
    suspend fun upsert(assets: Assets)

}