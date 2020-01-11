package com.example.country.presenter;

import com.example.country.model.CountryDetails;
import com.example.country.views.CountryView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CountryPresenterImplTest {

    private CountryPresenterImpl countryPresenter;
    private CountryView mockView;
    private CountryDetails mockCountryDetails;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        this.countryPresenter = new CountryPresenterImpl(mockView);
    }

    @Test
    public void testFactData() {
        verify(mockView, times(1)).getFactsData(mockCountryDetails);
    }


}