package com.akturk.cv.design.atom;


import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;

public class HeaderAtom extends AppCompatTextView implements Atom {

    public HeaderAtom(Context context) {
        super(context);

        init();
    }

    public HeaderAtom(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public HeaderAtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        setTypeface(Typeface.DEFAULT_BOLD);
    }
}
