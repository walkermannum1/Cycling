package com.example.bi.cycling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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

        //set baseIndex
        public int getBaseIndex() {
            return mBaseIndex;
        }

        public View initForButton(LayoutInflater inflater) {

            View view = inflater.inflate(R.layout.item_two, null);

            Button button = (Button) view.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, SecondActivity.class);
                    startActivity(intent);
                    activity.finish();
                }

            });
            return view;
        }

        public View showImages(LayoutInflater inflater) {
            View view = inflater.inflate(R.layout.item_one, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(IMAGES[getBaseIndex()]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            return view;
        }
    }
}
