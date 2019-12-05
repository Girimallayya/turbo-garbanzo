package com.example.country.interactor;

import android.content.Context;

import com.example.country.R;
import com.example.country.helper.NetworkUtil;
import com.example.country.model.CountryDetails;
import com.example.country.rest.ApiConstants;
import com.example.country.rest.ApiHelper;
import com.example.country.rest.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryInteractorImpl implements CountryInteractor {

    @Override
    public void factsData(final Context context, final onFcatsDataListener listener) {

        if(NetworkUtil.isOnline(context))
        {
            ApiHelper apiHelper = new ApiHelper.Builder().endPoint(ApiConstants.GET_FACTS).build();
            Call<CountryDetails> countryDetailsCall = RestClient.get().getCountryData(apiHelper.getFinalUrl());
            countryDetailsCall.enqueue(new Callback<CountryDetails>() {
                @Override
                public void onResponse(Call<CountryDetails> call, Response<CountryDetails> response) {
                    listener.onSuccess(context,response.body());
                }

                @Override
                public void onFailure(Call<CountryDetails> call, Throwable t) {
                  listener.onError(t.getMessage());
                }
            });


        }
        else
        {
            NetworkUtil.showNetworkDialog(context,context.getResources().getString(R.string.no_internet),
                    context.getResources().getString(R.string.alert));
        }


    }
}
