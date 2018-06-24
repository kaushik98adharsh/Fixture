package com.example.kaushikadharsh.myapplication;

import android.graphics.Bitmap;
import android.util.Log;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

class fixing {

     String team1 , team2;
     Bitmap mIcon1,mIcon2;
     String mDate;
     String mVenue;
     String mTime;

     //Constructor

    public fixing(String team1, String team2, Bitmap mIcon1, Bitmap mIcon2, String mDate, String mVenue, String mTime) {
        this.team1 = team1;
        this.team2 = team2;
        this.mIcon1 = mIcon1;
        this.mIcon2 = mIcon2;
        this.mDate = mDate;
        this.mVenue = mVenue;
        this.mTime = mTime;
    }

    //setter and getter


    public String getTeam1() {
        Log.d("fixing const","works");
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public Bitmap getmIcon1() {
        return mIcon1;
    }

    public void setmIcon1(Bitmap mIcon1) {
        this.mIcon1 = mIcon1;
    }

    public Bitmap getmIcon2() {
        return mIcon2;
    }

    public void setmIcon2(Bitmap mIcon2) {
        this.mIcon2 = mIcon2;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmVenue() {
        return mVenue;
    }

    public void setmVenue(String mVenue) {
        this.mVenue = mVenue;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}
