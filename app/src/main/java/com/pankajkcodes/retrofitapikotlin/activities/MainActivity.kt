package com.pankajkcodes.retrofitapikotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.pankajkcodes.retrofitapikotlin.R
import com.pankajkcodes.retrofitapikotlin.api.QuotesApi
import com.pankajkcodes.retrofitapikotlin.api.RetrofitInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textView)
        val quotesAPI = RetrofitInstance.getInstance().create(QuotesApi::class.java)
        try {
            GlobalScope.launch {
                val result = quotesAPI.getQuotes(2)
                if (result == null){
                    Toast.makeText(this@MainActivity,"failed",Toast.LENGTH_LONG).show()
                }else{
                    Log.d("TAG",result.body().toString())
                    text.text = result.body().toString()

                }

            }
        } catch (e: Exception) {
            Log.d("TAG",e.message.toString())
        }


    }
}