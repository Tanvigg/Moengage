package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moe.pushlibrary.MoEHelper;
import com.moengage.core.Properties;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //building event attributes
        Properties properties = new Properties()
                .addAttribute("sign-up-date", new Date())
                .addAttribute("type", "user-pass");
        //sample track event
        MoEHelper.getInstance(getApplicationContext()).trackEvent("login", properties);

        //identify user uniquely across installs and devices
        //this id should be the one the app uses to identify user in your system
        //should be set only after log-in
        MoEHelper.getInstance(getApplicationContext()).setUniqueId("androidsample");

        //tracking user attributes samples
        MoEHelper.getInstance(getApplicationContext()).setFullName("Michael Jordan");
        MoEHelper.getInstance(getApplicationContext()).setEmail("a@b.com");
        MoEHelper.getInstance(getApplicationContext()).setUserAttribute("last ordered", new Date());
    }


}