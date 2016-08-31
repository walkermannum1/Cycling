package com.example.bi.cycling;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.*;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.bi.navigationtab.NavigationTab;

/**
 * Created by user on 2016/8/29.
 */
public class SecondActivity extends Activity {

    private ViewPager mViewPager;

    private NavigationTab mNavigationTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        setUI();
    }


    private void initUI() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mNavigationTab = (NavigationTab) findViewById(R.id.ngt);
    }
    private void setUI() {
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }
        });
    }
}
