package com.stjepanmrganic.adoptr;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddressAPI {
    private static final String BASE_API_ADDRESS = "https://api.namefake.com";
    private static IAPICallAddress APIAddressInterface;
    public static IAPICallAddress getApiInterface() {
        if (APIAddressInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_API_ADDRESS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            APIAddressInterface = retrofit.create(IAPICallAddress.class);
        }
        return APIAddressInterface;
    }
}