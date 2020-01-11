package com.example.country.interactor;

import android.content.Context;

import com.example.country.model.CountryDetails;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import retrofit2.Call;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class CountryInteractorImplTest {

    @Spy
    private CountryInteractorImpl countryInteractor = new CountryInteractorImpl();
    @Mock
    private CountryDetails countryDetailsMock;
    @Mock
    private Call<CountryDetails> countryDetailsCallMock;
    @Mock
    private Context contextMock;
    @Mock
    private CountryInteractor.onFcatsDataListener onFcatsDataListenerMock;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void factsData() {
        Mockito.doReturn(countryDetailsMock).when(countryInteractor).factsData(contextMock, onFcatsDataListenerMock);
        Mockito.doReturn(countryDetailsCallMock).when(countryDetailsMock);
    }
}