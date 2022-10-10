package com.yhg.domain.model

data class MemoItem (
    var id: Long?,
    var title: String,
    var content: String,
    val time: String
)