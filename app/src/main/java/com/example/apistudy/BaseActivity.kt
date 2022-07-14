package com.example.apistudy

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.apistudy.api.APIList
import com.example.apistudy.api.ServerAPI
import retrofit2.create

abstract class BaseActivity: AppCompatActivity() {
    lateinit var mContext: Context
    lateinit var apiList: APIList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        val retrofit = ServerAPI.getRetrofit()
        apiList = retrofit.create(APIList::class.java)
    }

    abstract fun setupEvents()
    abstract fun setValues()
}