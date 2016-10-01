package com.example.preethakumaresan.cabshare;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by PREETHA KUMARESAN on 04-09-2016.
 */
public class initializer extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {

        Log.e("myTag","reached initializer");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initializer);
        TextView txt = (TextView) findViewById(R.id.textView2);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font.ttf");
        txt.setTypeface(typeface);

        Button btn=(Button)findViewById(R.id.join);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(initializer.this,joingroup.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(i);
            }
        });






    }
}
