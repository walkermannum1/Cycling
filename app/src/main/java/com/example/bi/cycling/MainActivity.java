package com.example.bi.cycling;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.UserDictionary;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private PagerAdapter mAdapter;
    private Circle circle;
    private Activity activity = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initAcitity();
        setContentView(R.layout.activity_main);

        activity = this;
        showForSecondActivity();


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        circle = (Circle) findViewById(R.id.circle);

        scrollPager();
        mAdapter = new PagerAdapter(getSupportFragmentManager());
        mAdapter.setForActivity(activity);
        viewPager.setAdapter(mAdapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    //handle the UI
    private void initAcitity() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //First setup will laoding the pages
    private void showForSecondActivity() {
        //prefrenceManager used to help create Prefrence hierarchies from activity or XML
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mSharedPreferences.edit();

        boolean b = mSharedPreferences.getBoolean(UserDictionary.Words.KEY_ONE, true);
        if (b) {
            editor.putBoolean(UserDictionary.Words.KEY_ONE, false);
            editor.commit();
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            finish();
        }
    }

    //Rendering circle
    private void scrollPager() {
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                circle.choose(position);
            }
        });
    }
}
