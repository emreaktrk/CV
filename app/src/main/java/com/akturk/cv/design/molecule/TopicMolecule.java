package com.akturk.cv.design.molecule;

import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

import com.akturk.cv.R;
import com.akturk.cv.design.atom.LineAtom;


public class TopicMolecule extends LinearLayoutCompat implements Molecule {

    private LineAtom _bold;
    private LineAtom _completer;

    public TopicMolecule(Context context) {
        super(context);

        init();
    }

    public TopicMolecule(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public TopicMolecule(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.molecule_topic, this);

        setGravity(Gravity.CENTER_VERTICAL);
        setOrientation(VERTICAL);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();

        _bold = findViewById(R.id.topic_bold);
        _completer = findViewById(R.id.topic_completer);
    }

    public void setBold(CharSequence bold) {
        _bold.setText(bold);
    }

    public void setCompleter(CharSequence completer) {
        _completer.setText(completer);
    }
}
