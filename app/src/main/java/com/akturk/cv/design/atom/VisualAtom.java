package com.akturk.cv.design.atom;


import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.facebook.drawee.view.SimpleDraweeView;

public class VisualAtom extends AppCompatImageView implements Atom {

    public VisualAtom(Context context) {
        super(context);
    }

    public VisualAtom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VisualAtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }
}
