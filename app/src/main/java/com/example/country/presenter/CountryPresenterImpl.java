package com.example.country.presenter;

import android.content.Context;

import com.example.country.interactor.CountryInteractor;
import com.example.country.interactor.CountryInteractorImpl;
import com.example.country.model.CountryDetails;
import com.example.country.views.CountryView;

public class CountryPresenterImpl implements CountryPresenter, CountryInteractor.onFcatsDataListener {
    private CountryView countryView;
    private CountryInteractor countryInteractor;


    public CountryPresenterImpl(CountryView countryView) {
        this.countryView = countryView;
        this.countryInteractor = new CountryInteractorImpl();
    }


    @Override
    public void getFactsData(Context context) {
        countryInteractor.factsData(context, this);
    }

    @Override
    public void onSuccess(Context context, CountryDetails countryDetails) {
        countryView.getFactsData(countryDetails);
    }

    @Override
    public void onError(String message) {
        countryView.hideProgress();
    }
}
