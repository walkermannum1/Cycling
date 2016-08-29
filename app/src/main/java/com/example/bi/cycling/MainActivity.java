package com.example.bi.cycling;

import android.support.v4.app.FragmentActivity;

import com.example.bi.cycling.utils.Words;
import com.example.bi.cycling.PagerAdapter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private com.example.bi.cycling.PagerAdapter mAdapter;
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
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        circle = (Circle) findViewById(R.id.circle);

        scrollPager();
        mAdapter = new com.example.bi.cycling.PagerAdapter(getSupportFragmentManager());
        mAdapter.setForActivity(activity);
        viewPager.setAdapter(mAdapter);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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

        boolean b = mSharedPreferences.getBoolean(Words.KEY_ONE, true);
        if (b) {
            editor.putBoolean(Words.KEY_ONE, false);
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

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.bi.cycling/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.bi.cycling/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
