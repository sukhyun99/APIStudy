package com.example.apistudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.apistudy.databinding.ActivityMainBinding
import com.example.apistudy.datas.BasicResponse
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : BaseActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        apiList.getRequestInfoList("9FNSfnhkG+1WbctErcEfdXtf92YWSmGWGfuvXmHUUnrklWm6qXqxau2ex95ioMvW/Di+9vqvAXyRrsWRF2QqYw=="
        , "1", "10", "json", "202206", "202206")
            .enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if(response.isSuccessful) {
                        Toast.makeText(mContext, "성공", Toast.LENGTH_SHORT).show()
                        Log.d("성공", response.body()!!.toString())
                        
                        val resultCode = JSONObject(response.body()!!.toString())
                            .getJSONObject("response")
                            .getJSONObject("header")
                            .getString("resultCode")

                        Log.d("resultCode", resultCode)
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("실패", t.stackTraceToString())
                }

            })
    }
}