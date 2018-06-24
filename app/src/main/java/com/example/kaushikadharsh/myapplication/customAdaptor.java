package com.example.kaushikadharsh.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kaushikadharsh.myapplication.R;

import java.util.ArrayList;
import java.util.List;

class CustomAdaptor extends BaseAdapter {

    private Context mContext;
    private List<fixing> mFixingList;

    //constructor


    public CustomAdaptor(Context mContext, List<fixing> mFixingList) {
        this.mContext = mContext;
        this.mFixingList = mFixingList;
    }



    @Override
    public int getCount() {
        return mFixingList.size();
    }


    @Override
    public Object getItem(int position) {
        return mFixingList.get(position);
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Log.d("customAdapt","in");
         view =  View.inflate(mContext,R.layout.activity_list_layout,null);

         TextView venue = view.findViewById(R.id.venue_act);
         TextView date = view.findViewById(R.id.date_act);
         TextView time = view.findViewById(R.id.time_act);

        date.setText((CharSequence) mFixingList.get(position).getmDate());
        venue.setText(mFixingList.get(position).getmVenue());
        time.setText((CharSequence) mFixingList.get(position).getmTime());

        return view;
    }
}
