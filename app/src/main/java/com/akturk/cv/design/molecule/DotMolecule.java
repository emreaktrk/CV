package com.akturk.cv.design.molecule;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

import com.akturk.cv.R;
import com.akturk.cv.design.atom.LineAtom;
import com.akturk.cv.design.atom.SubLineAtom;


public class DotMolecule extends LinearLayoutCompat implements Molecule {

    private LineAtom _bold;
    private LineAtom _completer;

    public DotMolecule(Context context) {
        super(context);

        init();
    }

    public DotMolecule(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public DotMolecule(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.molecule_dot, this);

        setGravity(Gravity.CENTER_VERTICAL);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();

        _bold = findViewById(R.id.dot_bold);
        _completer = findViewById(R.id.dot_completer);
    }

    public void setBold(CharSequence bold) {
        _bold.setText(bold);
    }

    public void setCompleter(CharSequence completer) {
        _completer.setText(completer);
    }
}
