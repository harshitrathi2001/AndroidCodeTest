package com.android.code.test.myapplication

import dagger.Module
import dagger.Provides

@Module
class AppModule constructor(private var myApplication: MyApplication){

    @Provides
    fun provideMyRetroApplication():MyApplication{
        return myApplication
    }
}