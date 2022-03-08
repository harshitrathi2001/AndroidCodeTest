package com.android.code.test.myapplication.network.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.code.test.myapplication.MyApplication
import com.android.code.test.myapplication.network.di.APIComponent
import com.android.code.test.myapplication.network.repository.RetrofitRepository
import javax.inject.Inject

class RetroViewModelFactory : ViewModelProvider.Factory {

    @Inject
    lateinit var retrofitRepository: RetrofitRepository

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val apiComponent: APIComponent = MyApplication.apiComponent
        apiComponent.inject(this)

        if (modelClass.isAssignableFrom(com.android.code.test.myapplication.network.viewmodel.ViewModel::class.java)) {
            return ViewModel(retrofitRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}