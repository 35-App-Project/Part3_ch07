package com.choi.part3_ch07.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.choi.part3_ch07.data.dao.ContentDao
import com.choi.part3_ch07.model.ContentEntity

@Database(entities = [ContentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contentDao() : ContentDao
}