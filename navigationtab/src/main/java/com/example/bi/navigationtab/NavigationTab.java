package com.example.bi.navigationtab;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by guang on 2016/8/30.
 */
public class NavigationTab extends View implements ViewPager.OnPageChangeListener{

    public NavigationTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public NavigationTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigationTab(Context context) {
        super(context);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
