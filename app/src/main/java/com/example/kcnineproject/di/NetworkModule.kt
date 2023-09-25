package com.example.kcnineproject.di

import com.example.kcnineproject.api.AssetsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideAssetsService(): AssetsService {
        return AssetsService.create()
    }
}
