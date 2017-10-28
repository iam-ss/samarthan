package com.samarthan.shubham.samarthan;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by SHUBHAM on 28-10-2017.
 */

public interface ApiInterface {

    @POST("employer/login")
    Call<EmployeDataAndConfirmation> getEmployer(@Body EmployeeLoginDetails employeeLoginDetails);

    @POST("seeker/login")
    Call<SeekerCover> getSeeker(@Body EmployeeLoginDetails employeeLoginDetails);

}
