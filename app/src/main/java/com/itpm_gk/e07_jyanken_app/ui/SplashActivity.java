package com.itpm_gk.e07_jyanken_app.ui;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.itpm_gk.e07_jyanken_app.CustomApplication;
import com.itpm_gk.e07_jyanken_app.R;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        CustomApplication application = (CustomApplication)getApplication();
        if (application.isSplashDisplayed()) {
            Log.d(TAG, "Splash already displayed.");
            startActivity(MainActivity.createIntent(this));
            finish();
            return;
        }

        Handler handler = new Handler(getMainLooper());
        handler.postDelayed(() -> {
            application.setSplashDisplayed(true);
            startActivity(MainActivity.createIntent(SplashActivity.this));
            finish();
        }, 2000);
    }
}
