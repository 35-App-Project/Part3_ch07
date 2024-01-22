package com.choi.part3_ch07.di

import android.content.Context
import androidx.room.Room
import com.choi.part3_ch07.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDataBase(@ApplicationContext appContext:Context) : AppDatabase {
        return Room.databaseBuilder(appContext, AppDatabase::class.java, "my.db")
            .fallbackToDestructiveMigration()
            .build()
    }

}