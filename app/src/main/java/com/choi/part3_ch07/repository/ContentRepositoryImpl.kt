package com.choi.part3_ch07.repository

import com.choi.part3_ch07.data.dao.ContentDao
import com.choi.part3_ch07.model.ContentEntity
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentDao: ContentDao
) : ContentRepository {
    override fun loadList() = contentDao.selectAll()


    override suspend fun insert(item: ContentEntity) {
        contentDao.insert(item)
    }

    // 충돌이 발생 했을 때 덮어 쓰기를 하기 때문에 insert 로
    override suspend fun modify(item: ContentEntity) {
        contentDao.insert(item)
    }

    override suspend fun delete(item: ContentEntity) {
        contentDao.delete(item)
    }
}