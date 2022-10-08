package com.yhg.cleanarchitecturesample.di

import com.yhg.data.dao.MemoDao
import com.yhg.data.source.room.MemoLocalDataSource
import com.yhg.data.source.room.MemoLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesMemoLocalDataSource(memoDao: MemoDao): MemoLocalDataSource = MemoLocalDataSourceImpl(memoDao)
}