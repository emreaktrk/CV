package com.akturk.cv.design.molecule;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

import com.akturk.cv.R;
import com.akturk.cv.design.atom.LineAtom;
import com.akturk.cv.design.atom.SubLineAtom;


public class CardMolecule extends CardView implements Molecule {

    private LineAtom _bold;
    private LineAtom _completer;
    private SubLineAtom _info;

    public CardMolecule(Context context) {
        super(context);

        init();
    }

    public CardMolecule(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public CardMolecule(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.molecule_card, this);

        setUseCompatPadding(true);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();

        _bold = findViewById(R.id.card_bold);
        _completer = findViewById(R.id.card_completer);
        _info = findViewById(R.id.card_info);
    }

    public void setBold(CharSequence bold) {
        _bold.setText(bold);
    }

    public void setCompleter(CharSequence completer) {
        _completer.setText(completer);
    }

    public void setInfo(CharSequence info) {
        _info.setText(info);
    }
}
