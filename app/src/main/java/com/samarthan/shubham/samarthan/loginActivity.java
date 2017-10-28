package com.samarthan.shubham.samarthan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginActivity extends AppCompatActivity {
    EditText email,password;
     String lEmail,lpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle bundle = getIntent().getExtras();
        int status = bundle.getInt("personStatus");
         email= (EditText) findViewById(R.id.loginEmail);
        password= (EditText) findViewById(R.id.loginPassword);

        if(status==1){

            Button loginButton=findViewById(R.id.loginButton);
            loginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    Call<EmployeDataAndConfirmation> call=ApiClient.getInterface().getDetails();
                    call.enqueue(new Callback<EmployeDataAndConfirmation>() {
                        @Override
                        public void onResponse(Call<EmployeDataAndConfirmation> call, Response<EmployeDataAndConfirmation> response) {

                            if(response.isSuccessful()) {
                                EmployeDataAndConfirmation employeDataAndConfirmation = response.body();
                                Toast.makeText(getApplicationContext(),employeDataAndConfirmation.getConfirmation(),Toast.LENGTH_SHORT);

                            }
                            else
                            {
                                Toast.makeText(getApplication(),"nooooo",Toast.LENGTH_SHORT);
                            }
                        }

                        @Override
                        public void onFailure(Call<EmployeDataAndConfirmation> call, Throwable t) {
                            Toast.makeText(getApplication(),"failed",Toast.LENGTH_SHORT);
                        }
                    });

//                    EmployeeLoginDetails employeeLoginDetails=new EmployeeLoginDetails();
//                    lEmail=email.getText().toString();
//                    lpassword=password.getText().toString();
//
//
//                    employeeLoginDetails.setEmail(lEmail);
//                    employeeLoginDetails.setPassword(lpassword);
//                    Log.d("GA",employeeLoginDetails.getEmail());
//
//                    Call<Employer> call = ApiClient.getInterface().getEmployer(employeeLoginDetails);
//                    call.enqueue(new Callback<Employer>() {
//                        @Override
//                        public void onResponse(Call<Employer> call, Response<Employer> response) {
//                            if(response.isSuccessful())
//                            {   Intent intent = new Intent(loginActivity.this,employerDetailPage.class);
//                                Log.v("agayaresult",response.body().getEmail());
//                                startActivity(intent);
//
//                            }
//                            else
//                            {
//                                Toast.makeText(getApplicationContext(),response.message(),Toast.LENGTH_SHORT);
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<Employer> call, Throwable t) {
//
//
//                        }
//                    });

                }
            });

        }

    }
}
