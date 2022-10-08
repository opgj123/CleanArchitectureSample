package com.yhg.data.source.room

import com.yhg.data.model.MemoEntity
import kotlinx.coroutines.flow.Flow

interface MemoLocalDataSource {
    suspend fun insertMemo(content: MemoEntity): Long
    fun getAllMemo(): Flow<List<MemoEntity>>
}