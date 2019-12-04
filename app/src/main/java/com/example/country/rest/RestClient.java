package com.example.country.rest;

import com.example.country.helper.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static RestApi restApi;

    static
    {
        setupRestClient();
    }

    private static void setupRestClient() {
        Retrofit aRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(createGsonConverter())
                .build();

        restApi = aRetrofit.create(RestApi.class);

    }

    private static Converter.Factory createGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();
        return GsonConverterFactory.create(gson);
    }

    public static RestApi get()
    {
        return restApi;
    }
}
