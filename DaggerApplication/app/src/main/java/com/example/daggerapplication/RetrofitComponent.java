package com.example.daggerapplication;


import javax.inject.Singleton;

import dagger.Component;

@Component(modules = NetworkModule.class)
@Singleton
public interface RetrofitComponent {
     RetrofitComponent retrofitComponent();

     void inject(MainActivity mainActivity);
}
