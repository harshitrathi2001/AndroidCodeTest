package com.android.code.test.myapplication.network.repository

import com.android.code.test.myapplication.network.model.Info
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("posts")
    fun makeRequest(): Call<List<Info>>
}