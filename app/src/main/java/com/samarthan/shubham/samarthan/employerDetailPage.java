package com.samarthan.shubham.samarthan;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class employerDetailPage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_detail_page);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View f1=findViewById(R.id.fragment1);
        View f2=f1.findViewById(R.id.fragment11);
        f2.findViewById(R.id.SalaryRange);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView UserNametv=(TextView)headerView.findViewById(R.id.empname);
        TextView UserEmailtv=(TextView)headerView.findViewById(R.id.empemail);





        Spinner acceptableDisability = (Spinner)f2.findViewById(R.id.AcceptableDisability);

        final Employer employer = (Employer) getIntent().getParcelableExtra("employee-parcel");

        UserEmailtv.setText(employer.getEmail());
        UserNametv.setText(employer.getName());
        EditText editText = (EditText) findViewById(R.id.CompanyName);
        editText.setText(employer.getName(),TextView.BufferType.EDITABLE);
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setTypeface(null, Typeface.BOLD);
        editText.setTextSize(30);

        Button submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Job job=new Job();

                EditText companyname,jobtitle,jobdes,perks;
                jobtitle=findViewById(R.id.JobTitle);
                jobdes=findViewById(R.id.JobDescription);
                companyname=findViewById(R.id.CompanyName);
                perks=findViewById(R.id.Perks);
                Spinner spinner=findViewById(R.id.AcceptableDisability);
                Spinner range=findViewById(R.id.SalaryRange);
                String minmax=range.getSelectedItem().toString();
              String result[]=minmax.split("-");
              job.setMin(Integer.parseInt(result[0]));
                job.setMax(Integer.parseInt(result[1]));
                job.setDisability(spinner.getSelectedItem().toString());
                job.setJobTitle(jobtitle.getText().toString());
                job.setJobDescription(jobdes.getText().toString());
                job.setEmail(employer.getEmail());
                job.setPerks(perks.getText().toString());

                //Toast.makeText(getApplicationContext(),job.getDisability()+job.getEmail()+job.getJobDescription(),Toast.LENGTH_SHORT).show();


                Call<jobTemp> call = ApiClient.getInterface().getjob(job);
                call.enqueue(new Callback<jobTemp>() {
                    @Override
                    public void onResponse(Call<jobTemp> call, Response<jobTemp> response) {
                        if(response.isSuccessful())
                        {  if(response.body().getConfirmation().compareTo("success")==0)
                            Toast.makeText(getApplicationContext(),"posted succesfully",Toast.LENGTH_SHORT).show();
                           else
                            Toast.makeText(getApplicationContext(),response.body().getMessage().toString(),Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),response.body().getMessage().toString(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<jobTemp> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"error occured ,check network",Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });

    }

    private void formOnClear()
    {
        EditText companyname,jobtitle,jobdes,perks;
        jobtitle=findViewById(R.id.JobTitle);
        jobdes=findViewById(R.id.JobDescription);

        perks=findViewById(R.id.Perks);
        Spinner spinner=findViewById(R.id.AcceptableDisability);
        Spinner range=findViewById(R.id.SalaryRange);
        jobtitle.setText("");
        jobdes.setText("");
        perks.setText("");
        spinner.setSelection(0);
        range.setSelection(0);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.employer_detail_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Pending_app) {
            // Handle the camera action
        } else if (id == R.id.JobTitle) {

        } else if (id == R.id.Sugg_Form) {

        } else if (id == R.id.find_emp) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
