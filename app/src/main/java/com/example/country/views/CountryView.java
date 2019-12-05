package com.example.country.views;

import com.example.country.model.CountryDetails;

public interface CountryView {

    void showProgress();

    void hideProgress();

    void getFactsData(CountryDetails countryDetails);
}
