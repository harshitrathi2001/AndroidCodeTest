package com.android.code.test.myapplication.network.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.code.test.myapplication.network.model.Info
import com.android.code.test.myapplication.network.repository.RetrofitRepository

class ViewModel(private val retrofitRepository: RetrofitRepository) : ViewModel() {

   var infoLiveData: LiveData<List<Info>> = MutableLiveData()

    init {
        fetchPostInfoFromRepository()
    }

    private fun fetchPostInfoFromRepository() {
        infoLiveData = retrofitRepository.fetchPostInfoList()
    }
}