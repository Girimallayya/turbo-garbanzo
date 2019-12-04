package com.example.country.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.country.R;

public class SplashActivity extends AppCompatActivity {
    public static final int TIME_IN_MSEC = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, CountryActivity.class);
                startActivity(intent);
                finish();
            }
        },TIME_IN_MSEC);
    }
}
