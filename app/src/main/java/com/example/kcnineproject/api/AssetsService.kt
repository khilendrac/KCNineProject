package com.example.kcnineproject.api

import com.example.kcnineproject.data.Assets
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface AssetsService {
    @GET("afr")
    suspend fun getAssets(): Assets

    companion object {
        private const val BASE_URL =
            "https://bruce-v2-mob.fairfaxmedia.com.au/1/alfred_live/67184313/offline/"

        fun create(): AssetsService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AssetsService::class.java)
        }
    }

}