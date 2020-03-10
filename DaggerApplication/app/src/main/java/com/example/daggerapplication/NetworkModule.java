package com.example.daggerapplication;

import java.util.concurrent.TimeUnit;


import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
   public HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    public OkHttpClient providesOkHttpClient(HttpLoggingInterceptor interceptor){
        OkHttpClient client = new  OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10 , TimeUnit.SECONDS)
                .writeTimeout(10 , TimeUnit.SECONDS)
                .readTimeout(30 , TimeUnit.SECONDS)
                .build();
        return  client;
    }


    @Provides
    public Retrofit provideRetrofit(OkHttpClient client ) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        return retrofit;
    }

    @Provides
    public  DIYAApis provideDIYAApis(Retrofit retrofit) {
        return retrofit.create(DIYAApis.class);
    }
}
