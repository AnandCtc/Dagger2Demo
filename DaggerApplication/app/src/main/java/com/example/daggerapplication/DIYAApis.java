package com.example.daggerapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DIYAApis {

    @GET("/api/users?page=2")
    public Call<UserList> getDeliveryDetails() ;


    @GET("/api/users?page=2")
    public  Call<UserList> getCustomerDetails();
}
