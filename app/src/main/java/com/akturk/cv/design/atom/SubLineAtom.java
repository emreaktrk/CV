package com.akturk.cv.design.atom;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;


public class SubLineAtom extends AppCompatTextView implements Atom {

    public SubLineAtom(Context context) {
        super(context);

        init();
    }

    public SubLineAtom(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public SubLineAtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
    }
}
