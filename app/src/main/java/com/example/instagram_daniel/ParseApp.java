package com.example.instagram_daniel;

import android.app.Application;

import com.parse.Parse;

public class ParseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        final Parse.Configuration config = new Parse.Configuration.Builder(this)
                .applicationId("myAppId")
                .clientKey("myMasterKey")
                .server("http://instagram-daniel.herokuapp.com/parse")
                .build();

        Parse.initialize(config);
    }
}
