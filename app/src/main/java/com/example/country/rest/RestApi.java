package com.example.country.rest;

import com.example.country.model.CountryDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RestApi {

    @GET
    Call<CountryDetails> getCountryData(@Url String iUrl);
}
