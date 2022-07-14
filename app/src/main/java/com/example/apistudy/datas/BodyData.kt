package com.example.apistudy.datas

data class BodyData(
    val items: ItemData,
    val numOfRows: Int,
    val pageNo: Int,
    val totalCount: Int,
)
