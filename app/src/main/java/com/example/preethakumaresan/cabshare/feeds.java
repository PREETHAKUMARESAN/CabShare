package com.example.preethakumaresan.cabshare;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by PREETHA KUMARESAN on 04-09-2016.
 */
public class feeds extends AppCompatActivity {

    ListView list;
    ListViewAdapter adapter;
    String[] destination;
    ImageView pro,fee;
    String[] date;
    String[] time;
    EditText editsearch;
    ArrayList<cabdetails> arraylist = new ArrayList<cabdetails>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feeds);


        pro=(ImageView) findViewById(R.id.profile);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(feeds.this,profile.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                startActivity(i);
            }
        });

        fee=(ImageView) findViewById(R.id.filter);
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builderSingle = new AlertDialog.Builder(feeds.this);

                builderSingle.setTitle("Customize your Cab Journey");

                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                        (
                        feeds.this,
                        android.R.layout.select_dialog_singlechoice);
                arrayAdapter.add("Time");
                arrayAdapter.add("Destination");
                arrayAdapter.add("Date");

                builderSingle.setAdapter(
                        arrayAdapter,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String strName = arrayAdapter.getItem(which);
                                if(strName.equals("Destination"))
                                {Intent i=new Intent(feeds.this,maps.class);
                                startActivity(i);}}
                        });
                builderSingle.show();


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builderSingle = new AlertDialog.Builder(feeds.this);

                Intent i= new Intent(feeds.this,newdetials.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });


        date = new String[] { "1/8/16", "2/8/16", "3/8/16", "4/8/16", "5/8/16", "6/8/16", "7/8/16" };

        destination = new String[] { "Chatram", "CBT", "CBT",
                "Railway", "Railway station", "Airport", "airport" };

        time = new String[] { "12.30", "1.30",
                "3.30", "2.30", "1.45", "1.00",
                "6.00" };

        list = (ListView) findViewById(R.id.listview);

        for (int i = 0; i < destination.length; i++)
        {
            cabdetails wp = new cabdetails(destination[i], date[i], time[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.search);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });



    }



}