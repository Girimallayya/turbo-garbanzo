package com.example.country.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.country.R;
import com.example.country.helper.NetworkUtil;
import com.example.country.presenter.CountryPresenter;
import com.example.country.presenter.CountryPresenterImpl;

public class CountryActivity extends AppCompatActivity implements CountryView{

    private ProgressDialog progressDialog;
    private CountryPresenter countryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryPresenter = new CountryPresenterImpl(this);
        if(NetworkUtil.isOnline(CountryActivity.this))
        {
            countryPresenter.getFactsData(CountryActivity.this);
        }
        else
        {
            //no internet
        }
    }

    @Override
    public void showProgress() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.please_wait));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.show();

    }

    @Override
    public void hideProgress() {
        if(progressDialog != null && progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }

    }

    @Override
    public void getFactsData() {
       hideProgress();
    }

    @Override
    public void noInternetRetry() {

    }
}
