package com.example.kaushikadharsh.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class FixingAdaptor extends BaseAdapter {

    private Context mContext;
    private List<fixing> mFixingList;

    //constructor


    public FixingAdaptor(Context mContext, List<fixing> mFixingList) {
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("fixing adaptor","works");
        View FixView = View.inflate(mContext,R.layout.custom_row,null);
        Log.d("fixing adaptor 2","in");
        TextView mTeamname = FixView.findViewById(R.id.Vsteam);
        Log.d("fixing adaptor 3","in");
        ImageView icon1 = FixView.findViewById(R.id.ic1);
        Log.d("fixing adaptor 4","in");

        ImageView icon2 = FixView.findViewById(R.id.ic2);
        Log.d("fixing adaptor 5","in");
        TextView date = FixView.findViewById(R.id.date);
        Log.d("fixing adaptor 6","in");
        TextView venue = FixView.findViewById(R.id.venue);
        Log.d("fixing adaptor 7","in");
        TextView mtime = FixView.findViewById(R.id.time);
        Log.d("fixing adaptor 8","in");


        //setting text for TExt view
        String tempname = mFixingList.get(position).getTeam1() + " Vs " + mFixingList.get(position).getTeam2();
        mTeamname.setText(tempname);
        Log.d("after team name","in");
        icon1.setImageBitmap(mFixingList.get(position).getmIcon1());
        Log.d("icon1 bitmap","in");
        icon2.setImageBitmap(mFixingList.get(position).getmIcon2());
        date.setText((CharSequence) mFixingList.get(position).getmDate());
        venue.setText(mFixingList.get(position).getmVenue());
        mtime.setText((CharSequence) mFixingList.get(position).getmTime());




        return FixView;
    }
}
