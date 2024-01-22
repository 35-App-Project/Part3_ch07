package com.choi.part3_ch07.repository

import com.choi.part3_ch07.model.ContentEntity
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    fun loadList() : Flow<List<ContentEntity>>

    suspend fun insert(item: ContentEntity)

}