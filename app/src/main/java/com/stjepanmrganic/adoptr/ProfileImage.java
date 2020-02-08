
package com.stjepanmrganic.adoptr;


import com.google.gson.annotations.SerializedName;


public class ProfileImage {

    @SerializedName("message")
    private String ImageURL;
    @SerializedName("status")
    private String mStatus;

    public String getImageURL(){
        return ImageURL;
    }

    public void setImageURL(String message) {
        ImageURL = message;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
