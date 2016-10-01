package com.example.preethakumaresan.cabshare;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by PREETHA KUMARESAN on 06-09-2016.
 */
public class newdetials extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newdetails);

        TextView txt = (TextView) findViewById(R.id.textView2);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        txt.setTypeface(typeface);
    }
}
