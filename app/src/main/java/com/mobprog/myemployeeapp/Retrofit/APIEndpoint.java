package com.mobprog.myemployeeapp.Retrofit;

import com.mobprog.myemployeeapp.MainModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIEndpoint {
    @GET("stage2/people/?nim=2301883643&nama=Albertius_Christopher_Nathan") Call<MainModel> getEmployeesAL();
}
