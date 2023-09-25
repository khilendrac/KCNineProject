package com.example.kcnineproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
@HiltAndroidApp
class App: Application() {
    companion object {
        //Declaring the application context here in order to make this available as required.
        lateinit var appContext: App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        initContext()
    }

    private fun initContext() {
        appContext = this
    }
}