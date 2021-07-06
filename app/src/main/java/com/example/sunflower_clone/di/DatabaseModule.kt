package com.example.sunflower_clone.di

import android.content.Context
import com.example.sunflower_clone.data.AppDatabase
import com.example.sunflower_clone.data.PlantDao
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
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    fun providePlantDao(database: AppDatabase): PlantDao {
        return database.plantDao()
    }
}