package com.yhg.cleanarchitecturesample.di

import android.content.Context
import androidx.room.Room
import com.yhg.data.dao.MemoDao
import com.yhg.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun providesAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "memo.db")
        .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun providesMemoDao(appDatabase: AppDatabase): MemoDao = appDatabase.memoDao()
}