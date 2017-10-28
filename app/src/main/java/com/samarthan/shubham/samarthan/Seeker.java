package com.samarthan.shubham.samarthan;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by tanvi on 28-10-2017.
 */

public class Seeker implements Serializable {

    private String password,name,email,phone,disability;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }


}
