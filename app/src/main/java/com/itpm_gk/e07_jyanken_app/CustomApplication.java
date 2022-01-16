package com.itpm_gk.e07_jyanken_app;

import android.app.Application;

public class CustomApplication extends Application {

    private boolean splashDisplayed = false;

    public boolean isSplashDisplayed() {
        return splashDisplayed;
    }

    public void setSplashDisplayed(boolean displayed) {
        splashDisplayed = displayed;
    }
}
