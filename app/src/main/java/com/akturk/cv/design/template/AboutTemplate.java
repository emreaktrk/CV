package com.akturk.cv.design.template;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.akturk.cv.R;
import com.akturk.cv.design.organism.MeOrganism;
import com.akturk.cv.design.organism.ProfileOrganism;
import com.akturk.cv.model.Me;
import com.akturk.cv.ui.base.BaseFragment;
import com.kinvey.android.Client;
import com.kinvey.android.callback.KinveyListCallback;
import com.kinvey.android.store.DataStore;
import com.kinvey.java.store.StoreType;

import java.util.Arrays;
import java.util.List;


public class AboutTemplate extends BaseFragment implements Template {

    private MeOrganism _me;
    private ProfileOrganism _photo;

    @Override protected int getLayoutResId() {
        return R.layout.template_about;
    }

    @Override protected void onViewInflated(View layout) {
        super.onViewInflated(layout);

        _me = layout.findViewById(R.id.about_me);
        _photo = layout.findViewById(R.id.about_profile);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadData();
        loadPhoto();
    }

    private void loadPhoto() {
        _photo.setLink("https://storage.googleapis.com/48e1a3f4818c429ab608df4823b01f38/d90548bd-da29-464f-a6aa-71549ca32f08/profile.jpeg");
    }

    private void loadData() {
        DataStore<Me> collection = DataStore.collection("me", Me.class, StoreType.NETWORK, Client.sharedInstance());
        collection.find(new KinveyListCallback<Me>() {
            @Override public void onSuccess(List<Me> list) {
                Me me = list.get(0);
                _me.setFullname(me._fullname);
                _me.setProfession(me._profession, me._location);
                _me.setInfo(me._about);
                _me.setPhone(me._phone);
                _me.setMail(me._email);

                configureShortcuts(me._phone, me._email);
            }

            @Override public void onFailure(Throwable throwable) {

            }
        });
    }

    private void configureShortcuts(CharSequence phone, CharSequence mail) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {
            ShortcutManager manager = getContext().getSystemService(ShortcutManager.class);

            Intent dial = new Intent(Intent.ACTION_DIAL);
            dial.setData(Uri.parse("tel:" + phone));

            Intent compose = new Intent(Intent.ACTION_SENDTO);
            compose.setData(Uri.parse("mailto:"));
            compose.putExtra(Intent.EXTRA_EMAIL, new String[]{mail.toString()});

            if (manager != null) {
                manager.setDynamicShortcuts(
                        Arrays.asList(
                                new ShortcutInfo
                                        .Builder(getContext(), "dial")
                                        .setShortLabel("Dial")
                                        .setLongLabel("Dial the number")
                                        .setIcon(Icon.createWithResource(getContext(), R.drawable.shortcut_dial))
                                        .setIntent(dial)
                                        .build(),
                                new ShortcutInfo
                                        .Builder(getContext(), "compose")
                                        .setShortLabel("Compose")
                                        .setLongLabel("Compose a mail")
                                        .setIcon(Icon.createWithResource(getContext(), R.drawable.shortcut_compose))
                                        .setIntent(compose)
                                        .build()));
            }
        }

    }
}
