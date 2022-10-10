package com.yhg.domain.usecase

import com.yhg.domain.model.MemoItem
import com.yhg.domain.repository.MemoRepository

class UpdateMemoUseCase(private val repository: MemoRepository) {
    suspend fun execute(memoItem: MemoItem) = repository.updateMemo(memoItem)
}