package com.android.code.test.myapplication.network.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.code.test.R

class NetworkActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.network_layout)
        replaceFragment()
    }

    private fun replaceFragment(){
       supportFragmentManager
           .beginTransaction()
           .replace(R.id.container_retro_room,RetroFragment())
           .commit()
    }
}