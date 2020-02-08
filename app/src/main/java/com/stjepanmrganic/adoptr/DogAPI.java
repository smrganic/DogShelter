package com.stjepanmrganic.adoptr;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogAPI {
    private static final String BASE_API = "https://dog.ceo/api/";
    private static IAPICallDog apiInterface;
    public static IAPICallDog getApiInterface() {
        if (apiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = retrofit.create(IAPICallDog.class);
        }
        return apiInterface;
    }
}