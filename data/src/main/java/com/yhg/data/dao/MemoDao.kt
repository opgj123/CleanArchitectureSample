package com.yhg.data.dao

import androidx.room.*
import com.yhg.data.model.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMemo(content: MemoEntity): Long

    @Query("SELECT * FROM memo ORDER BY id DESC")
    fun getAllMemo(): Flow<List<MemoEntity>>

    @Delete
    fun deleteMemo(memo: MemoEntity)
}