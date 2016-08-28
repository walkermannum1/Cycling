package com.example.bi.cycling.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.bi.cycling.R;

/**
 * Created by guang on 2016/8/28.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private static Activity activity;
    private static final int[] IMAGES = {R.drawable.T1, R.drawable.T2, R.drawable.T3, R.drawable.T4, R.drawable.T5};
    public static int sum = IMAGES.length;

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }
    //Get activity from MainActivity
    public void setForActivity(Activity activity) {
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }
}
