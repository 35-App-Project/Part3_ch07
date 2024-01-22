package com.choi.part3_ch07.data.di

import com.choi.part3_ch07.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun providesContentDao(appDatabase: AppDatabase) = appDatabase.contentDao()

}