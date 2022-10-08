package com.yhg.cleanarchitecturesample.di

import com.yhg.data.repository.MemoRepositoryImpl
import com.yhg.data.source.room.MemoLocalDataSource
import com.yhg.domain.repository.MemoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesMemoRepository(repository: MemoRepositoryImpl): MemoRepository = repository
}