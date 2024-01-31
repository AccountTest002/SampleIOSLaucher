package com.example.launcherios17

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch


object LoadAppHelper {

    private val loadAllAppsFlow =
        MutableSharedFlow<ArrayList<ItemApp>>(replay = 1, extraBufferCapacity = 0)

    fun getAllDeviceApps(onDone: (ArrayList<ItemApp>) -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            loadAllAppsFlow.collect {
                onDone(it)
            }
        }
    }


    fun loadApps(context: Context) {
        CoroutineScope(Dispatchers.IO).launch {
            val deviceApps = loadAllDeviceApp(context)
            loadAllAppsFlow.emit(deviceApps)
        }
    }

    private fun loadAllDeviceApp(context: Context): java.util.ArrayList<ItemApp> {
        val deviceApps = ArrayList<ItemApp>()

        val apps: List<ApplicationInfo> =
            context.packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
        val pm = context.packageManager
        for (i in apps.indices) {
            val app = apps[i]

            if (pm.getLaunchIntentForPackage(app.packageName) != null) {
                deviceApps.add(
                    ItemApp(
                        pm.getApplicationLabel(app).toString(),
                        app.packageName,
                        app.loadIcon(pm)
                    )
                )
            }

        }

        return deviceApps
    }

}