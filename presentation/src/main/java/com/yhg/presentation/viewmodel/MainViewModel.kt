package com.yhg.presentation.viewmodel

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.yhg.domain.model.MemoItem
import com.yhg.domain.usecase.DeleteMemoUseCase
import com.yhg.domain.usecase.GetAllMemoUseCase
import com.yhg.domain.usecase.InsertMemoUseCase
import com.yhg.presentation.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllMemoUseCase: GetAllMemoUseCase,
    private val insertMemoUseCase: InsertMemoUseCase,
    private val deleteMemoUseCase: DeleteMemoUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    private val _memoConfirmText = MutableLiveData<Event<String>>()
    val memoConfirmText : LiveData<Event<String>> get() = _memoConfirmText

    private val _memoData = MutableLiveData<Event<MemoItem>>()
    val memoData: LiveData<Event<MemoItem>> get() = _memoData

    fun insertMemo(title: String, content: String){
        val simpleDate = SimpleDateFormat("yy.MM.dd EEE, a HH:mm", Locale.KOREAN)
        val strNow: String = simpleDate.format(Date(System.currentTimeMillis()))
        val memoItem = MemoItem(null, title, content, strNow)
        CoroutineScope(IO).launch {
            insertMemoUseCase.execute(memoItem)
        }
        _memoConfirmText.value = Event("save")
    }

    fun deleteMemo(item: MemoItem){
        CoroutineScope(IO).launch {
            deleteMemoUseCase.execute(item)
        }
        _memoConfirmText.value = Event("delete")
    }

    fun getAllMemos() = getAllMemoUseCase.execute().flowOn(IO).catch{e: Throwable -> }


    fun setMemoId(memoItem: MemoItem){
        _memoData.value = Event(memoItem)
    }
}
