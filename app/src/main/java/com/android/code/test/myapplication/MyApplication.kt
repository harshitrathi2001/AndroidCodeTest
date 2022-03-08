package com.android.code.test.myapplication

import android.app.Application
import com.android.code.test.myapplication.network.di.APIComponent
import com.android.code.test.myapplication.network.di.APIModule
import com.android.code.test.myapplication.network.di.DaggerAPIComponent
import com.android.code.test.myapplication.network.repository.ApiUrl

class MyApplication : Application() {

    companion object {
        lateinit var apiComponent: APIComponent
    }

    override fun onCreate() {
        super.onCreate()
        apiComponent = initDaggerComponent()
    }

    private fun initDaggerComponent(): APIComponent {
        apiComponent = DaggerAPIComponent
            .builder()
            .aPIModule(APIModule(ApiUrl.BASE_URL))
            .build()
        return apiComponent

    }
}