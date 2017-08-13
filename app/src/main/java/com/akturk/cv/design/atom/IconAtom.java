package com.akturk.cv.design.atom;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;


public class IconAtom extends AppCompatImageView implements Atom {

    public IconAtom(Context context) {
        super(context);
    }

    public IconAtom(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconAtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
