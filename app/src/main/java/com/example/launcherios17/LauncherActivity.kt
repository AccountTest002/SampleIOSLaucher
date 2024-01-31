package com.example.launcherios17

import android.annotation.SuppressLint
import android.os.Bundle
import com.base.BaseActivity
import com.example.sampleioslaucher.R
import com.example.sampleioslaucher.databinding.ActivityLaucherBinding


/* loaded from: classes.dex */
class LauncherActivity : BaseActivity<ActivityLaucherBinding>(ActivityLaucherBinding::inflate) {

    override fun addEvent() {

    }

    override fun initView() {
        LoadAppHelper.getAllDeviceApps {
            binding.rv.adapter = AppItemAdapter(this, ArrayList(it.take(24)))
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {

    }
}