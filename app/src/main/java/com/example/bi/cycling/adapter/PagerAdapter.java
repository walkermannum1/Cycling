package com.example.bi.cycling.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    public Activity getForActivity(Activity activity) {
        return activity;
    }


    @Override
    public int getCount() {
        return IMAGES.length;
    }

    @Override
    public Fragment getItem(final int position) {
        return MyFragment.newInstance(position);
    }

    public static class MyFragment extends Fragment {

        private int mBaseIndex;
        //Factory pattern construct Fragment
        static MyFragment newInstance(int baseIndex) {
            MyFragment fragment = new MyFragment();
            fragment.setBaseIndex(baseIndex);
            return fragment;
        }

        public MyFragment() {
            super();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            //With button in the last picture
            if (getBaseIndex() == IMAGES.length - 1) {
                return initForButton(inflater);
            } else {
                return showImages(inflater);
            }
    }
}
