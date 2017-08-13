package com.akturk.cv;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.kinvey.android.Client;


public final class CVApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();

        new Client
                .Builder(this)
                .build();

        Fresco.initialize(this);
    }
}
