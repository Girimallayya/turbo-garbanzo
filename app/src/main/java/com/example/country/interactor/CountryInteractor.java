package com.example.country.interactor;

import android.content.Context;

import com.example.country.model.CountryDetails;

public interface CountryInteractor {

    void factsData(Context context, onFcatsDataListener listener);

    interface onFcatsDataListener {

        void onSuccess(Context context, CountryDetails countryDetails);

        void onError(String message);

    }
}
