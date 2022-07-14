package com.example.apistudy.api

import com.example.apistudy.datas.BasicResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIList {

    @GET("/B500001/drghtWaterMsg/infoList")
    fun getRequestInfoList(
        @Query("serviceKey") serviceKey: String,
        @Query("pageNo") pageNo: String,
        @Query("numOfRows") numOfRows: String,
        @Query("_type") _type: String,
        @Query("stDt") stDt: String,
        @Query("edDt") edDt: String,
    ): Call<String>
}