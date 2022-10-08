package com.yhg.presentation.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yhg.domain.model.MemoItem
import com.yhg.domain.usecase.GetAllMemoUseCase
import com.yhg.domain.usecase.InsertMemoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllAllMemoUseCase: GetAllMemoUseCase,
    private val insertMemoUseCase: InsertMemoUseCase
) : ViewModel(){
    val statusText = ObservableField("Hi! text in Local DB")

    val noDataNotification = ObservableBoolean(false)

    fun insertMemo(title: String, content: String){
        CoroutineScope(IO).launch {
            insertMemoUseCase.execute(MemoItem(null, title, content))
        }
        statusText.set("'$content' is inserted.")
    }

    fun getAllMemos() = getAllAllMemoUseCase.execute().flowOn(IO)
        .catch{e: Throwable -> }
}