package com.yhg.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yhg.data.dao.MemoDao
import com.yhg.data.model.MemoEntity

@Database(
    entities = [MemoEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun memoDao(): MemoDao
}