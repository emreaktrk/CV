package com.akturk.cv.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment extends Fragment {

    protected abstract @LayoutRes int getLayoutResId();

    @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(getLayoutResId(), container, false);
        onViewInflated(layout);

        return layout;
    }

    protected void onViewInflated(View layout) {

    }
}
