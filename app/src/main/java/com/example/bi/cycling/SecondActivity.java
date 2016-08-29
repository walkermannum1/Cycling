package com.example.bi.cycling;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by user on 2016/8/29.
 */
public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("Welcome coming!");
        textView.setTextSize(28);
        textView.setTextColor(Color.BLUE);
        textView.setGravity(Gravity.CENTER);

        setContentView(textView);
    }
}
