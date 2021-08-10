package com.example.sunflower_clone.di

import com.example.sunflower_clone.api.UnsplashService
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
    fun proviedUnsplashService(): UnsplashService {
        return UnsplashService.create()
    }
}