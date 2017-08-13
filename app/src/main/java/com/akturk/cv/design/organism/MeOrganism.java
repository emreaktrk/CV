package com.akturk.cv.design.organism;


import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;

import com.akturk.cv.design.atom.HeaderAtom;
import com.akturk.cv.design.atom.LineAtom;
import com.akturk.cv.design.atom.SubHeaderAtom;
import com.akturk.cv.design.molecule.MailMolecule;
import com.akturk.cv.design.molecule.PhoneMolecule;

import com.akturk.cv.R;

public class MeOrganism extends LinearLayoutCompat implements Organism {

    private HeaderAtom _fullname;
    private SubHeaderAtom _profession;
    private LineAtom _info;
    private PhoneMolecule _phone;
    private MailMolecule _mail;

    public MeOrganism(Context context) {
        super(context);

        init();
    }

    public MeOrganism(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public MeOrganism(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        inflate(getContext(), R.layout.organism_me, this);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();

        _fullname = findViewById(R.id.me_fullname);
        _profession = findViewById(R.id.me_profession);
        _info = findViewById(R.id.me_info);
        _phone = findViewById(R.id.me_phone);
        _mail = findViewById(R.id.me_mail);
    }

    public void setFullname(CharSequence fullname) {
        _fullname.setText(fullname);
    }

    @SuppressLint("SetTextI18n")
    public void setProfession(CharSequence profession, CharSequence location) {
        _profession.setText(profession + " | " + location);
    }

    public void setInfo(CharSequence info) {
        _info.setText(info);
    }

    public void setPhone(CharSequence phone) {
        _phone.setPhone(phone);
    }

    public void setMail(CharSequence mail) {
        _mail.setMail(mail);
    }
}
