package com.example.wta.IVS;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;


public class SlidesActivity extends AppCompatActivity implements View.OnClickListener {

    private PagerAdapter mPagerAdapter;

    ViewPager viewPager;

    CirclePageIndicator circlePageIndicator;

    Button bt_next;


    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        viewPager=findViewById(R.id.view_pager);
        bt_next = findViewById(R.id.bt_next);

        bt_next.setOnClickListener(this);


        List<Fragment> fragments = getFragments();
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(mPagerAdapter);
        circlePageIndicator.setViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == 3) {
                    setButtonViewGone();
                    bt_next.setVisibility(View.VISIBLE);
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


    /**
     * Adding all the fragments
     */
    private List<Fragment> getFragments() {
        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(new OnboardingFragment1());
        fList.add(new OnboardingFragment2());
        fList.add(new OnboardingFragment3());
        return fList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.bt_next:
                i = new Intent(this, Login.class);
                startActivity(i);
                this.finish();
                break;


        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
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

    private void setButtonViewGone() {
        bt_next.setVisibility(View.GONE);
    }

}

