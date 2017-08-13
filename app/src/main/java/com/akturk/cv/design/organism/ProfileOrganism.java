package com.akturk.cv.design.organism;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.akturk.cv.design.molecule.PhotoMolecule;


public class ProfileOrganism extends PhotoMolecule implements Organism {

    public ProfileOrganism(@NonNull Context context) {
        super(context);
    }

    public ProfileOrganism(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ProfileOrganism(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ProfileOrganism(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
