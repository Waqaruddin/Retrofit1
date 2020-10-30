package com.example.retrofitdemo

import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("/")
    suspend fun getData(): String

    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("https://www.google.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}