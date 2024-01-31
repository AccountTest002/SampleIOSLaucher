package com.example

import android.app.Application
import com.example.launcherios17.LoadAppHelper

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LoadAppHelper.loadApps(this)
    }
}