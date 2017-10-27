package com.samarthan.shubham.samarthan;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jobSeekerLogin(View view){
        Intent intent = new Intent(MainActivity.this,loginActivity.class);
        intent.putExtra("personStatus",0);
        startActivity(intent);
    }

    public void employerLogin(View view){
        Intent intent = new Intent(MainActivity.this,loginActivity.class);
        intent.putExtra("personStatus",1);
        startActivity(intent);
    }


}
