package com.samarthan.shubham.samarthan;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginActivity extends AppCompatActivity {
    EditText email, password;
    String lEmail, lpassword;
     Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Bundle bundle = getIntent().getExtras();
        int status = bundle.getInt("personStatus");
        email = (EditText) findViewById(R.id.loginEmail);
        password = (EditText) findViewById(R.id.loginPassword);

        if (status == 1) {

            loginButton = findViewById(R.id.loginButton);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginButton.setClickable(false);


                    EmployeeLoginDetails employeeLoginDetails = new EmployeeLoginDetails();
                    lEmail = email.getText().toString();
                    lpassword = password.getText().toString();


                    employeeLoginDetails.setEmail(lEmail);
                    employeeLoginDetails.setPassword(lpassword);

                    Call<EmployeDataAndConfirmation> call = ApiClient.getInterface().getEmployer(employeeLoginDetails);
                    call.enqueue(new Callback<EmployeDataAndConfirmation>() {
                        @Override
                        public void onResponse(Call<EmployeDataAndConfirmation> call, Response<EmployeDataAndConfirmation> response) {
                            if (response.isSuccessful())
                            {
                                EmployeDataAndConfirmation employeDataAndConfirmation = response.body();
                                if (employeDataAndConfirmation.getConfirmation().compareTo("success")==0) {
                                    Intent intent = new Intent(loginActivity.this,employerDetailPage.class);
                                    intent.putExtra("employee-parcel",employeDataAndConfirmation.getResult());
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(loginActivity.this, "Bad Email ID or Password", Toast.LENGTH_SHORT).show();
                                }
                                loginButton.setClickable(true);
                            }
                            else
                            {
                                Toast.makeText(loginActivity.this, "Bad Email ID or Password", Toast.LENGTH_SHORT).show();
                                loginButton.setClickable(true);
                            }
                        }

                        @Override
                        public void onFailure(Call<EmployeDataAndConfirmation> call, Throwable t) {
                            Toast.makeText(loginActivity.this, "No network", Toast.LENGTH_SHORT).show();
                            loginButton.setClickable(true);

                        }


                    });

                }
            });

        }
        else
        {
            loginButton = findViewById(R.id.loginButton);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginButton.setClickable(false);


                    EmployeeLoginDetails employeeLoginDetails = new EmployeeLoginDetails();
                    lEmail = email.getText().toString();
                    lpassword = password.getText().toString();


                    employeeLoginDetails.setEmail(lEmail);
                    employeeLoginDetails.setPassword(lpassword);

                    Call<SeekerCover> call = ApiClient.getInterface().getSeeker(employeeLoginDetails);
                    call.enqueue(new Callback<SeekerCover>() {
                        @Override
                        public void onResponse(Call<SeekerCover> call, Response<SeekerCover> response) {
                            if (response.isSuccessful())
                            {
                                SeekerCover seekerCover = response.body();
                                if (seekerCover.getConfirmation().compareTo("success")==0) {
                                    Intent intent = new Intent(loginActivity.this,UserActivity.class);
                                    intent.putExtra("parcel",  seekerCover.getResult());
                                    Log.d("yeh",seekerCover.getResult().getEmail());
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(loginActivity.this, "Bad Email ID or Password", Toast.LENGTH_SHORT).show();
                                }
                                loginButton.setClickable(true);
                            }
                            else
                            {
                                Toast.makeText(loginActivity.this, "Bad Email ID or Password", Toast.LENGTH_SHORT).show();
                                loginButton.setClickable(true);
                            }

                        }

                        @Override
                        public void onFailure(Call<SeekerCover> call, Throwable t) {

                        }
                    });

                }
            });



        }

    }
}
