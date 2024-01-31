package com.luutinhit.launcherios17;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;

import com.example.sampleioslaucher.R;


/* loaded from: classes.dex */
public class SplashActivity extends Activity {


    @SuppressLint("MissingInflatedId")
    @Override
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash_activity);


        findViewById(R.id.btn_set_default).setOnClickListener(v -> {
            Intent selector = new Intent(Settings.ACTION_HOME_SETTINGS);
            selector.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(selector);
        });
    }
}
