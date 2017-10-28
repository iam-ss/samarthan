package com.samarthan.shubham.samarthan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SHUBHAM on 28-10-2017.
 */

public class ApiClient {
    private static ApiInterface mService;
    public static ApiInterface getInterface()
    {
        if(mService==null) {
            Gson gson = new GsonBuilder().excludeFieldsWithModifiers(Modifier.STATIC, Modifier.TRANSIENT).create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://samarthan.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory
                            .create(gson)).build();
            mService = retrofit.create(ApiInterface.class);
        }   return mService;
    }
}
