package com.akturk.cv.design.molecule;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.facebook.drawee.view.SimpleDraweeView;


public class PhotoMolecule extends SimpleDraweeView implements Molecule {

    public PhotoMolecule(@NonNull Context context) {
        super(context);
    }

    public PhotoMolecule(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoMolecule(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PhotoMolecule(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setLink(String link) {
        Uri uri = Uri.parse(link);
        setImageURI(uri);
    }
}
