package com.mobprog.myemployeeapp.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private static Retrofit retrofit;
    public  static APIEndpoint apiEnd(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://u73olh7vwg.execute-api.ap-northeast-2.amazonaws.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        return retrofit.create(APIEndpoint.class);
    }


}
