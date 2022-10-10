package com.yhg.domain.repository

import com.yhg.domain.model.MemoItem
import kotlinx.coroutines.flow.Flow

interface MemoRepository {
    fun getAllMemo(): Flow<List<MemoItem>>
    suspend fun insertMemo(memo: MemoItem): Long
    suspend fun deleteMemo(memo: MemoItem)
    suspend fun updateMemo(memo: MemoItem)
}