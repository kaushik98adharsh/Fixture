package com.example.kaushikadharsh.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Act2 extends AppCompatActivity {


    CustomAdaptor adapt;
    ArrayList<fixing> mteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act2);
        Log.d("Act2","in");
        Intent intent = getIntent();
       Bundle stuff = intent.getExtras();
        ListView fixlist = findViewById(R.id.singleFixList);
        fixlist.setAdapter(adapt);

        fixing Stuff = (fixing) stuff.getParcelable("EXTRA_STUFF");
        mteam.add(Stuff);
        adapt.notifyDataSetChanged();

    }
}
