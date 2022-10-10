package com.yhg.domain.usecase

import com.yhg.domain.model.MemoItem
import com.yhg.domain.repository.MemoRepository

class DeleteMemoUseCase(private val repository: MemoRepository) {
    suspend fun execute(memoItem: MemoItem) = repository.deleteMemo(memoItem)
}