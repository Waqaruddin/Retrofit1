package com.example.retrofitdemo

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRepository {

    suspend fun getData(){

        //Unable to create converter for retrofit2.Call<java.lang.String>
       val s =  MyApi().getData()
        Log.d("abc", s)
//            .enqueue(object : Callback<String>{
//                override fun onResponse(call: Call<String>, response: Response<String>) {
//                    val data = response.body()
//                    Log.d("abc", data.toString())
//                }
//
//                override fun onFailure(call: Call<String>, t: Throwable) {
//                    Log.d("abc3", t.message.toString())
//
//                }
//
//            })
    }
}