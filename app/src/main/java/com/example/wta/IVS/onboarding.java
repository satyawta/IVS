/*
package com.example.wta.IVS;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class onboarding extends AppCompatActivity implements View.OnClickListener{

    private ViewPager pager;
    private Button next;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        pager=findViewById(R.id.pager);
        next=findViewById(R.id.onboarding_button);

        List<Fragment> fragments = getFragments();
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
        pager.setAdapter(mPagerAdapter);


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if(position == 3){
                    setButtonViewGone();
                    next.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    */
/**
 * Adding all the fragments
 * <p>
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 *//*

    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(new OnboardingFragment1());
        fList.add(new OnboardingFragment2());
        fList.add(new OnboardingFragment3());
        return fList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.onboarding_button:
                pager.setCurrentItem(pager.getCurrentItem()+1, true);
                break;



        }
    }

    */
/**
 * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
 * sequence.
 *//*

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private List<Fragment> fragments;

        public ScreenSlidePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
    private void setButtonViewGone(){
        next.setVisibility(View.GONE);
    }

}
*/
