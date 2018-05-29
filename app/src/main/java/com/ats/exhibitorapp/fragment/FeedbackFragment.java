package com.ats.exhibitorapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ats.exhibitorapp.R;

import static com.ats.exhibitorapp.fragment.FeedbackQuestionFragment.quetionList;

public class FeedbackFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button btnSubmit;

    public static int no = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        viewPager.setAdapter(new SectionsPagerAdapter(getChildFragmentManager()));

        no = quetionList.size();

        return view;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        Context context;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return FeedbackQuestionFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return no;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return String.valueOf(position + 1);

        }
    }


}
