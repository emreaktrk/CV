package com.akturk.cv.design.molecule;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

import com.akturk.cv.R;
import com.akturk.cv.design.atom.LineAtom;


public class BulletMolecule extends LinearLayoutCompat implements Molecule {

    private LineAtom _bold;

    public BulletMolecule(Context context) {
        super(context);

        init();
    }

    public BulletMolecule(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public BulletMolecule(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.molecule_bullet, this);

        setGravity(Gravity.CENTER_VERTICAL);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();

        _bold = findViewById(R.id.dot_bold);
    }

    public void setBold(CharSequence bold) {
        _bold.setText(bold);
    }
}
