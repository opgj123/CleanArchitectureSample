package com.yhg.domain.usecase

import com.yhg.domain.model.MemoItem
import com.yhg.domain.repository.MemoRepository

class InsertMemoUseCase(private val repository: MemoRepository) {
    suspend fun execute(memoItem: MemoItem): Long = repository.insertMemo(memoItem)
}