package com.example.testapplication;

import android.app.Application;

import com.example.testapplication.db.ObjectBox;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ObjectBox.init(this);
    }
}
