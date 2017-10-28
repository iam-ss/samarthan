package com.samarthan.shubham.samarthan;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by SHUBHAM on 28-10-2017.
 */

public class Employer implements Parcelable{
    private String name;
    private ArrayList<String> joblist;
    private String phone;

    @Override
    public int describeContents() {
        return 0;
    }

    public Employer(){

    }

    public Employer(Parcel in) {
        name = in.readString();
        joblist = in.createStringArrayList();
        phone = in.readString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getJoblist() {
        return joblist;
    }

    public void setJoblist(ArrayList<String> joblist) {
        this.joblist = joblist;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeStringList(joblist);
        parcel.writeString(phone);
    }

    public static final Parcelable.Creator<Employer> CREATOR= new Parcelable.Creator<Employer>(){
        public Employer createFromParcel(Parcel in) {
            return new Employer(in);
        }

        public Employer[] newArray(int size) {
            return new Employer[size];
        }
    };
}

