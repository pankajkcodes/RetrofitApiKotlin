package com.pankajkcodes.retrofitapikotlin.api

import com.pankajkcodes.retrofitapikotlin.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


// SIMPLE WORK LIKE DAO
interface QuotesApi {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page:Int) : Response<QuoteList>

    // BASE_URL + "quotes?page=1"
}