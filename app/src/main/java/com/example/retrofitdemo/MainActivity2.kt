package com.example.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(IO).launch {
            MyRepository().getData()
        }
    }
}




//RETROFIT
//interface API{
//    fun s:Person
//}

//interface API{
//    suspend fun s:Person
//}

//class Repository{
//    suspend fun m(){
//        api.s()
//    }
//}
