package com.akturk.cv.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.akturk.cv.R;
import com.akturk.cv.design.page.PhonePage;
import com.akturk.cv.design.page.TabletPage;
import com.akturk.cv.push.GCMService;
import com.akturk.cv.ui.base.BaseActivity;
import com.akturk.cv.util.DeviceUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.kinvey.android.Client;
import com.kinvey.android.model.User;
import com.kinvey.android.store.UserStore;
import com.kinvey.java.core.KinveyClientCallback;

import java.io.IOException;

public class HomeActivity extends BaseActivity {

    @Override protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (isLoggedIn()) {
            loadPage();
            registerPush();
        } else {
            login();
        }
    }

    private boolean isLoggedIn() {
        return Client
                .sharedInstance()
                .getActiveUser() != null;
    }

    private void login() {
        try {
            UserStore.login(Client.sharedInstance(), new KinveyClientCallback<User>() {
                @Override public void onSuccess(User user) {
                    loadPage();
                    registerPush();
                }

                @Override public void onFailure(Throwable throwable) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void registerPush() {
        int result = GoogleApiAvailability
                .getInstance()
                .isGooglePlayServicesAvailable(this);
        if (result != ConnectionResult.SUCCESS) {
            return;
        }

        Client
                .sharedInstance()
                .push(GCMService.class)
                .initialize(getApplication());
    }

    private void loadPage() {
        Fragment page = DeviceUtils.isTablet(this) ? new TabletPage() : new PhonePage();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_container, page)
                .commitAllowingStateLoss();
    }
}
