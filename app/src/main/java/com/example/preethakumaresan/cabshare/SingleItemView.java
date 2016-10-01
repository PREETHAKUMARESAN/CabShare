package com.example.preethakumaresan.cabshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by PREETHA KUMARESAN on 04-09-2016.
 */
public class SingleItemView extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initializer);
        Button btn=(Button)findViewById(R.id.join);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SingleItemView.this,joingroup.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(i);
            }
        });
    }
}
