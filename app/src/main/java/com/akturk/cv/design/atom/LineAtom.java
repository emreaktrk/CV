package com.akturk.cv.design.atom;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;


public class LineAtom extends AppCompatTextView implements Atom {

    public LineAtom(Context context) {
        super(context);

        init();
    }

    public LineAtom(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public LineAtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
    }
}
