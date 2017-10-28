package com.samarthan.shubham.samarthan;

import java.util.ArrayList;

/**
 * Created by SHUBHAM on 28-10-2017.
 */

public class Employer {
    private String name;
    private ArrayList<String> joblist;
    private String phone;

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
}
