package com.choi.part3_ch07.di

import com.choi.part3_ch07.data.dao.ContentDao
import com.choi.part3_ch07.repository.ContentRepository
import com.choi.part3_ch07.repository.ContentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(contentDao: ContentDao) : ContentRepository
     =  ContentRepositoryImpl(contentDao)

}