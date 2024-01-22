package com.choi.part3_ch07.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// 테이블 형태
@Entity(tableName = "Content")
data class ContentEntity(
    @PrimaryKey(true)
    val id : Int=0,

    @ColumnInfo
    var content: String,

    @ColumnInfo
    var memo : String? = null,

    @ColumnInfo
    var isDone : Boolean = false,

) : Serializable