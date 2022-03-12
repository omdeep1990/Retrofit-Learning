package com.omdeep.myretrofit.UserPojo;

import com.google.gson.annotations.SerializedName;

public class AddressUserResponse {

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipcode;

    @SerializedName("geo")
    private GeoUserResponse geoUserResponse;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public GeoUserResponse getGeoUserResponse() {
        return geoUserResponse;
    }
}
