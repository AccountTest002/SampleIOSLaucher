package com.luutinhit.launcherios17;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.example.sampleioslaucher.R;

/* loaded from: classes.dex */
public class FakeLauncher extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_activity);
    }
}