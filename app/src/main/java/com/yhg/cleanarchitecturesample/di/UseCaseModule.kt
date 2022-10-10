package com.yhg.cleanarchitecturesample.di

import com.yhg.domain.repository.MemoRepository
import com.yhg.domain.usecase.DeleteMemoUseCase
import com.yhg.domain.usecase.GetAllMemoUseCase
import com.yhg.domain.usecase.InsertMemoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    fun providesGetAllMemoUseCase(repository: MemoRepository): GetAllMemoUseCase =
        GetAllMemoUseCase(repository)

    @Provides
    fun providesInsertMemoUseCase(repository: MemoRepository): InsertMemoUseCase =
        InsertMemoUseCase(repository)

    @Provides
    fun providesDeleteMemoUseCase(repository: MemoRepository): DeleteMemoUseCase =
        DeleteMemoUseCase(repository)
}