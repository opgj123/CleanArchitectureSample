package com.yhg.data.repository

import com.yhg.data.mapper.map
import com.yhg.data.mapper.mapperToMemo
import com.yhg.data.source.room.MemoLocalDataSource
import com.yhg.domain.model.MemoItem
import com.yhg.domain.repository.MemoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(private val memoLocalDataSource: MemoLocalDataSource): MemoRepository {
    override fun getAllMemo(): Flow<List<MemoItem>> = memoLocalDataSource.getAllMemo().map { memos -> mapperToMemo(memos) }

    override suspend fun insertMemo(memo: MemoItem): Long = memoLocalDataSource.insertMemo(memo.map())

}