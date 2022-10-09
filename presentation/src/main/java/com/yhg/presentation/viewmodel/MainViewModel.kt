package com.yhg.presentation.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.SavedStateHandle
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
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllAllMemoUseCase: GetAllMemoUseCase,
    private val insertMemoUseCase: InsertMemoUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    val memoId = savedStateHandle.getLiveData("memo_id", -1)

    val statusText = ObservableField("Hi! text in Local DB")

    val noDataNotification = ObservableBoolean(false)

    fun insertMemo(title: String, content: String){
        val simpleDate = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val strNow: String = simpleDate.format(Date(System.currentTimeMillis()))
        val memoItem = MemoItem(null, title, content, strNow)
        Log.d("LOGD", "memoItem : $memoItem")
        CoroutineScope(IO).launch {
            insertMemoUseCase.execute(memoItem)
        }
    }

    fun getAllMemos() = getAllAllMemoUseCase.execute().flowOn(IO)
        .catch{e: Throwable -> }
}