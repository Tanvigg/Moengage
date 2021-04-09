package com.example.sample;

import android.app.Application;
import android.content.SharedPreferences;

import com.moe.pushlibrary.MoEHelper;
import com.moengage.core.LogLevel;
import com.moengage.core.MoEngage;
import com.moengage.core.config.LogConfig;
import com.moengage.core.model.AppStatus;

public class MoEDemo extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // configure MoEngage initializer
        MoEngage moEngage =
                new MoEngage.Builder(this, "EU4BXB4BGL7YKTHCM6AQZ5YU")//enter your own app id
                        .configureLogs(new LogConfig(LogLevel.VERBOSE, false))
                        // production
                        .build();
        // initialize MoEngage SDK
        MoEngage.initialise(moEngage);

        // install update differentiation
        trackInstallOrUpdate();

    }

    private void trackInstallOrUpdate() {
        //keys are just sample keys, use suitable keys for the apps
        SharedPreferences preferences = getSharedPreferences("demoapp", 0);
        AppStatus appStatus = AppStatus.INSTALL;
        if (preferences.getBoolean("has_sent_install", false)) {
            if (preferences.getBoolean("existing", false)) {
                appStatus = AppStatus.UPDATE;
            }
            MoEHelper.getInstance(getApplicationContext()).setAppStatus(appStatus);
            preferences.edit().putBoolean("has_sent_install", true).apply();
            preferences.edit().putBoolean("existing", true).apply();
        }
    }


}