package com.yhg.data.source.room

import com.yhg.data.dao.MemoDao
import com.yhg.data.model.MemoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemoLocalDataSourceImpl @Inject constructor(private val memoDao: MemoDao): MemoLocalDataSource {

    override suspend fun insertMemo(content: MemoEntity): Long = memoDao.insertMemo(content)

    override suspend fun deleteMemo(content: MemoEntity) = memoDao.deleteMemo(content)

    override fun getAllMemo(): Flow<List<MemoEntity>> = memoDao.getAllMemo()
}