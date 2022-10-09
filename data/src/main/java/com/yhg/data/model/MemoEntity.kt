package com.yhg.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memo")
data class MemoEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Long?,
    val title: String,
    val content: String,
    val time: String
)
