package com.akturk.cv.design.atom;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.akturk.cv.R;


public class TitleAtom extends AppCompatTextView implements Atom {

    public TitleAtom(Context context) {
        super(context);

        init();
    }

    public TitleAtom(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public TitleAtom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        setTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
    }

    public void setTitle(CharSequence title) {
        setText(title);
    }
}
