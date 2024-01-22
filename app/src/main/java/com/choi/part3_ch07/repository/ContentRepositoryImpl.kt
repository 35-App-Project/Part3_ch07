package com.choi.part3_ch07.repository

import com.choi.part3_ch07.data.dao.ContentDao
import com.choi.part3_ch07.model.ContentEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(private val contentDao: ContentDao) :
    ContentRepository {
    override fun loadList(): Flow<List<ContentEntity>> {
       return contentDao.selectAll()
    }

    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }
}