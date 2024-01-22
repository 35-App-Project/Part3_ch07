package com.choi.part3_ch07.repository

import com.choi.part3_ch07.model.ContentEntity
import kotlinx.coroutines.flow.Flow


/*
 Data Source 에 접근 하기 위한 Repository
 이 프로젝트에서 Data Source 는 Room DB
 */
interface ContentRepository {

    fun loadList() : Flow<List<ContentEntity>>

    suspend fun insert(item: ContentEntity)

    suspend fun modify(item: ContentEntity)

    suspend fun delete(item: ContentEntity)

}