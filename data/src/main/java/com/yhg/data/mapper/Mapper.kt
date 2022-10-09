package com.yhg.data.mapper

import com.yhg.data.model.MemoEntity
import com.yhg.domain.model.MemoItem

// data -> domain
fun mapperToMemo(memos: List<MemoEntity>): List<MemoItem> {
    return memos.toList().map {
        MemoItem(it.id, it.title, it.content, it.time)
    }
}

fun MemoEntity.map() = MemoItem(
    id, title, content, time
)

// domain -> data
fun mapperToMemoEntity(memoItems: List<MemoItem>): List<MemoEntity> {
    return memoItems.toList().map{
        MemoEntity(it.id, it.title, it.content, it.time)
    }
}

fun MemoItem.map() = MemoEntity(
    id, title, content, time
)