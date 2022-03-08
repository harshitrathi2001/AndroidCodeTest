package com.android.code.test.myapplication.network.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.code.test.myapplication.MyApplication
import com.android.code.test.myapplication.network.model.Info
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository {

    var infoMutableList: MutableLiveData<List<Info>> = MutableLiveData()

    @Inject
    lateinit var retrofit: Retrofit

    init {
        val apiComponent = MyApplication.apiComponent
        apiComponent.inject(this)
    }

    fun fetchPostInfoList(): LiveData<List<Info>> {
        val apiService: APIService = retrofit.create(APIService::class.java)
        val listInfo: Call<List<Info>> = apiService.makeRequest()

        listInfo.enqueue(object : Callback<List<Info>> {
            override fun onFailure(call: Call<List<Info>>, t: Throwable) {
                Log.d("RetroRepository", "Failed:::" + t.message)
            }

            override fun onResponse(
                call: Call<List<Info>>,
                response: Response<List<Info>>
            ) {
                val postInfoList = response.body()
                infoMutableList.value = postInfoList
            }
        })
        return infoMutableList
    }
}