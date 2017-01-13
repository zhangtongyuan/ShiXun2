package com.fnfh.m;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        Typeface type= Typeface.createFromAsset(getAssets(),"font/fei.ttf");
        TextView tv_content = (TextView) findViewById(R.id.tv_content);
        tv_content.setTypeface(type);
    }
}
