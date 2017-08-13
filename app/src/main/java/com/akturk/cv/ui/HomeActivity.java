package com.akturk.cv.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.akturk.cv.R;
import com.akturk.cv.design.page.PhonePage;
import com.akturk.cv.design.page.TabletPage;
import com.akturk.cv.ui.base.BaseActivity;
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
                }

                @Override public void onFailure(Throwable throwable) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPage() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.home_container, new PhonePage())
                .commitAllowingStateLoss();
    }
}
