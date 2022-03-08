package com.android.code.test.myapplication.network.di

import com.android.code.test.myapplication.AppModule
import com.android.code.test.myapplication.network.repository.RetrofitRepository
import com.android.code.test.myapplication.network.view.RetroFragment
import com.android.code.test.myapplication.network.viewmodel.ViewModel
import com.android.code.test.myapplication.network.viewmodel.RetroViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, APIModule::class])
interface APIComponent {
    fun inject(retrofitRepository: RetrofitRepository)
    fun inject(viewModel: ViewModel)
    fun inject(retroFragment: RetroFragment)
    fun inject(retroViewModelFactory: RetroViewModelFactory)
}