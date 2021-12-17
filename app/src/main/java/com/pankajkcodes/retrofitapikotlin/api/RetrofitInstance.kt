package com.pankajkcodes.retrofitapikotlin.api

import com.pankajkcodes.retrofitapikotlin.utils.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//BUILD RETROFIT OBJECT WORK LIKE DATABASE

object RetrofitInstance {

//    const val BASE_URL = "https://quotable.io/"

    fun getInstance() : Retrofit{

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}