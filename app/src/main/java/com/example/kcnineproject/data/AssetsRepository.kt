package com.example.kcnineproject.data

import android.util.Log
import com.example.kcnineproject.api.AssetsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AssetsRepository @Inject constructor(
    private val assetsService: AssetsService,
    private val assetsDao: AssetsDao
) {
    fun getAssets(): Flow<Assets> {

        return flow {
            // Fetch assets from the API
            val assetsFromApi = assetsService.getAssets()

            // Log fetched data from the API
            Log.e("AssetsRepository", "Fetched the data from API: ${assetsFromApi.assets.size}")

            // Update the local database
            assetsDao.upsert(assetsFromApi)

            // Emit assets from the local database
            val assetsFromLocalDb = assetsDao.getAssets()

            emit(assetsFromLocalDb)
        }.flowOn(Dispatchers.IO)

        /**
         * Performing in IO thread because it is useful for network requests or reading from a database,
         * to ensure that these operations are executed on a separate I/O thread.
         * This helps in maintaining a responsive UI and avoiding UI freezes.
         */

    }

}