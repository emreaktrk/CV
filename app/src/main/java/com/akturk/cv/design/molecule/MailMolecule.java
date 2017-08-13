package com.akturk.cv.design.molecule;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.akturk.cv.design.atom.LineAtom;

import com.akturk.cv.R;


public class MailMolecule extends LinearLayoutCompat implements Molecule, View.OnClickListener {

    private LineAtom _value;

    public MailMolecule(Context context) {
        super(context);

        init();
    }

    public MailMolecule(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public MailMolecule(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.molecule_mail, this);

        setClickable(true);
        setFocusable(true);
        setRipple();

        setOnClickListener(this);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();

        _value = findViewById(R.id.mail_value);
    }

    private void setRipple() {
        int[] attrs = new int[]{android.R.attr.selectableItemBackground};
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs);
        int backgroundResource = typedArray.getResourceId(0, 0);
        setForeground(ContextCompat.getDrawable(getContext(), backgroundResource));
        typedArray.recycle();
    }

    public void setMail(CharSequence mail) {
        _value.setText(mail);
    }

    @Override public void onClick(View view) {
        if (!TextUtils.isEmpty(_value.getText())) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{_value.getText().toString()});

            getContext().startActivity(Intent.createChooser(intent, "Email via..."));
        }
    }
}
