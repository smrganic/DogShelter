package com.stjepanmrganic.adoptr;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IAPICallDog {
    @GET("breeds/image/random")
    Call<ProfileImage> getProfileImage();
}
