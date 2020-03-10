package com.example.daggerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Inject
    DIYAApis diya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitComponent component = DaggerRetrofitComponent.create();
        // HOW TO INJECT THIS IN muLTIPLE Activites.
        component.inject(this);

        diya.getCustomerDetails().enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                // show here
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }
        });
    }
}
