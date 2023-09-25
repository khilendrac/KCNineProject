package com.example.kcnineproject.di

import android.content.Context
import androidx.room.Room
import com.example.kcnineproject.data.AssetsDatabase
import com.example.kcnineproject.utilities.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideAssetsDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AssetsDatabase::class.java, DATABASE_NAME)
            .build()

    @Provides
    fun provideAssetsDao(appDatabase: AssetsDatabase) = appDatabase.assetsDao()

}
