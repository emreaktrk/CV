package com.akturk.cv.design.page;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.akturk.cv.R;
import com.akturk.cv.design.template.CoursesAndCertificationsTemplate;
import com.akturk.cv.design.template.EducationTemplate;
import com.akturk.cv.design.template.ExperinceTemplate;
import com.akturk.cv.design.template.LanguagesTemplate;
import com.akturk.cv.design.template.LinksTemplate;
import com.akturk.cv.design.template.SkillsTemplate;
import com.akturk.cv.ui.base.BaseFragment;

public class PhonePage extends BaseFragment implements Page {

    private ViewPager templeter;

    @Override protected int getLayoutResId() {
        return R.layout.page_phone;
    }

    @Override protected void onViewInflated(View layout) {
        super.onViewInflated(layout);

        templeter = layout.findViewById(R.id.phone_templater);
    }

    @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        templeter.setAdapter(new Adapter(getChildFragmentManager()));
    }

    private static final class Adapter extends FragmentStatePagerAdapter {

        private Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ExperinceTemplate();
                case 1:
                    return new EducationTemplate();
                case 2:
                    return new CoursesAndCertificationsTemplate();
                case 3:
                    return new SkillsTemplate();
                case 4:
                    return new LanguagesTemplate();
                case 5:
                    return new LinksTemplate();
            }

            return null;
        }

        @Override public int getCount() {
            return 6;
        }

        @Override public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "EXPERINCE";
                case 1:
                    return "EDUCATION";
                case 2:
                    return "COURSES & CERTIFICATIONS";
                case 3:
                    return "SKILLS";
                case 4:
                    return "LANGUAGES";
                case 5:
                    return "LINKS";
            }

            return null;
        }
    }
}
