package com.example.kaushikadharsh.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_name = "com.example.kaushikadharsh.myapplication.Extra_name";
    public static final String EXTRA_STUFF = "com.example.kaushikadharsh.myapplication.Extra_stuff";

    ImageButton teamic1 ;
    ImageButton teamic2;
    Button mAddButton;
    Bitmap bitmap, ic1, ic2;
    EditText mTeamStuff,teamname1,teamname2;
    fixing Stuff;
    int flag1, flag2;
    ListView fixture;
    FixingAdaptor mFixadaptor;
    List<fixing> mfixlist;
   // String[] team = {"small boi","big boi","goot boi"};
    ArrayList<fixing> mTeam;
    //Adapter traillist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         teamic1 = findViewById(R.id.icon1);
         teamic2 = findViewById(R.id.icon2);
         fixture = findViewById(R.id.fixturelist);
         mAddButton = findViewById(R.id.addBTN);
         teamname1 = findViewById(R.id.defteam1);
         teamname2 = findViewById(R.id.defteam2);

        loadfixing();
        teamic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent1, 0);
                flag1 = 1;
                flag2 = 0;
            }
        });

       teamic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent2, 0);
                flag1 = 0;
                flag2 = 1;
            }
        });

        mTeam = new ArrayList<>();
        mFixadaptor = new FixingAdaptor(getApplicationContext(),mTeam);
        fixture.setAdapter(mFixadaptor);

        fixture.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mTeam.remove(position);
                mFixadaptor.notifyDataSetChanged();
                return false;
            }
        });

        teamic1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                openactivity2(Stuff,teamname1.getText().toString());
                return false;
            }
        });

        teamic2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                openactivity2(Stuff,teamname2.getText().toString());
                return false;
            }
        });

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View DailView = getLayoutInflater().inflate(R.layout.dialog_box,null);
                final EditText dailtime = DailView.findViewById(R.id.dailtexttime);
                final EditText dailvenue = DailView.findViewById(R.id.dailtextvenue);
                final EditText daildate = DailView.findViewById(R.id.dailtextdate);
                Button Applybtn = DailView.findViewById(R.id.applybtn);

                Applybtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         Stuff = new fixing(teamname1.getText().toString(),
                                teamname2.getText().toString(),ic1,ic2,daildate.getText().toString(),
                                dailvenue.getText().toString(),dailtime.getText().toString());
                        mTeam.add(Stuff);
                        mFixadaptor.notifyDataSetChanged();
                        savefixing();

                    }
                });

                mBuilder.setView(DailView);
                AlertDialog mDailog = mBuilder.create();
                mDailog.show();
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        bitmap = (Bitmap) data.getExtras().get("data");
        if (flag1 == 1 && flag2 == 0) {
            teamic1.setImageBitmap(bitmap);
            ic1 = bitmap;
        } else if (flag1 == 0 && flag2 == 1) {
            teamic2.setImageBitmap(bitmap);
            ic2 = bitmap;
        }
    }

    void savefixing()
    {
        Log.d("saving","in");
        SharedPreferences mShared = getSharedPreferences("mShared",MODE_PRIVATE);
        SharedPreferences.Editor editor = mShared.edit();
        Gson gson = new Gson();
        String Json = gson.toJson(mTeam);
        editor.putString("saved list",Json);
        editor.apply();
        Log.d("saving","done");

    }

    void loadfixing()
    {
        Log.d("loading","in");
        SharedPreferences mShared = getSharedPreferences("mshared",MODE_PRIVATE);
        Gson gson = new Gson();
        String Json = mShared.getString("saved list",null);
        Type mType = new TypeToken<ArrayList<fixing>>(){}.getType();
        mTeam = gson.fromJson(Json,mType);
        Log.d("loading","done");


    }

    void openactivity2(fixing icon,String name){
        Intent intent = new Intent(this,Act2.class);
       Bundle bundle  = new Bundle();

       bundle.putParcelable(EXTRA_STUFF, (Parcelable) icon);
       intent.putExtras(bundle);

        startActivity(intent);
    }
}
