package com.example.retrofitdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET





class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.google.com/")
                .addConverterFactory(ScalarsConverterFactory.create()) /// for getting data as string
                .build()

        val service:GitHubService = retrofit.create(GitHubService::class.java)
        val call = service.getData()
        Log.d("abc", call.toString())

        ///Get actual data
        //Asynchronus request needs a new thread
//        Thread{
//            val response = call.execute()
//            val data = response.body()
//            Log.d("abc1", data.toString())
//
//        }.start()


        //Synchronous request
//        // New thread is not required
////        Thread{
            val response = call.enqueue(object: Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val data = response.body()
                    Log.d("abc2", data.toString())
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("abc3", t.message.toString())
                }

            })
//
////        }.start()



    }
}

interface GitHubService {
    @GET("/")
    fun getData(): Call<String>
}