package com.example.launcherios17

import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Settings
import com.base.BaseActivity
import com.example.sampleioslaucher.databinding.SplashActivityBinding


/* loaded from: classes.dex */
class SplashActivity : BaseActivity<SplashActivityBinding>(SplashActivityBinding::inflate) {

    override fun addEvent() {
        binding.btnSetDefault.setOnClickListener {
            val selector = Intent(Settings.ACTION_HOME_SETTINGS)
            selector.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(selector)
        }
    }

    override fun initView() {

    }
}