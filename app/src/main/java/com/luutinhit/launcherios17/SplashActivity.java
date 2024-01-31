package com.luutinhit.launcherios17;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;

import com.example.sampleioslaucher.R;


/* loaded from: classes.dex */
public class SplashActivity extends Activity {


    @SuppressLint("MissingInflatedId")
    @Override
    // p000.ActivityC4384z7, p000.ActivityC4325yr, androidx.activity.ComponentActivity, p000.ActivityC3083pe, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash_activity);


        findViewById(R.id.btn_set_default).setOnClickListener(v -> {

            PackageManager packageManager = getPackageManager();
            ComponentName componentName = new ComponentName(this, FakeLauncher.class);
            packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

            Intent selector = new Intent(Settings.ACTION_HOME_SETTINGS);
            selector.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(selector);


        });
    }
}
