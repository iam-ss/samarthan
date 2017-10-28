package com.samarthan.shubham.samarthan;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.ParseException;

/**
 * Created by SHUBHAM on 28-10-2017.
 */

public class EmployeeLoginDetails implements Parcelable {
    private String password;
    private String email;

    public EmployeeLoginDetails(){

    }

    public EmployeeLoginDetails(Parcel in){
        password = in.readString();
        email = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(password);
        parcel.writeString(email);
    }

    public static final Parcelable.Creator<EmployeeLoginDetails> CREATOR= new Parcelable.Creator<EmployeeLoginDetails>(){
        public EmployeeLoginDetails createFromParcel(Parcel in) {
            return new EmployeeLoginDetails(in);
        }

        public EmployeeLoginDetails[] newArray(int size) {
            return new EmployeeLoginDetails[size];
        }
    };

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
