package com.stjepanmrganic.adoptr;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAPICallAddress {
    @GET(".")
    Call<Address> getAddress();
}