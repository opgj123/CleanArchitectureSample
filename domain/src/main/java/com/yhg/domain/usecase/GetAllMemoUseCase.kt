package com.yhg.domain.usecase

import com.yhg.domain.model.MemoItem
import com.yhg.domain.repository.MemoRepository
import kotlinx.coroutines.flow.Flow

class GetAllMemoUseCase(private val memoRepository: MemoRepository) {
    fun execute(): Flow<List<MemoItem>> = memoRepository.getAllMemo()
}