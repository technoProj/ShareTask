package com.example.gilkr.sharetask;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by gilkr on 11/4/2017.
 */

public class ParseInitialize extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this);
    }
}
