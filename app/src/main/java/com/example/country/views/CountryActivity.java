package com.example.country.views;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.country.R;
import com.example.country.helper.NetworkUtil;
import com.example.country.model.CountryDetails;
import com.example.country.model.Row;
import com.example.country.presenter.CountryPresenter;
import com.example.country.presenter.CountryPresenterImpl;
import com.example.country.views.adapter.FactsAdapter;

import java.util.List;

public class CountryActivity extends AppCompatActivity implements CountryView {

    private ProgressDialog progressDialog;
    private CountryPresenter countryPresenter;
    private RecyclerView recyclerView;
    private List<Row> factsList;
    private TextView textTitle;
    private ImageView imgRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        textTitle = findViewById(R.id.action_title);
        imgRefresh = findViewById(R.id.action_refresh);

        countryPresenter = new CountryPresenterImpl(this);
        CallFactsApi();

        imgRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallFactsApi();
            }
        });
    }

    private void CallFactsApi() {
        if (NetworkUtil.isOnline(CountryActivity.this)) {
            showProgress();
            countryPresenter.getFactsData(CountryActivity.this);
        } else {
            NetworkUtil.showNetworkDialog(CountryActivity.this, getResources().getString(R.string.no_internet),
                    getResources().getString(R.string.alert));
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
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

    }

    @Override
    public void getFactsData(CountryDetails countryDetails) {
        hideProgress();
        if (countryDetails != null && countryDetails.getRows().size() > 0) {
            factsList = countryDetails.getRows();
            textTitle.setText(countryDetails.getTitle());
            recyclerView.setLayoutManager(new LinearLayoutManager(CountryActivity.this));
            FactsAdapter factsAdapter = new FactsAdapter(CountryActivity.this, factsList);
            recyclerView.setAdapter(factsAdapter);
        }
    }

}
