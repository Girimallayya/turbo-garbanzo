package com.example.country.rest;

import android.text.TextUtils;

import com.example.country.helper.Constants;

public class ApiHelper {
    private String endPoint;
    private String finalUrl = "";
    private String extraQueryParams = "";

    public String getEndPoint() {
        return endPoint;
    }

    public String getFinalUrl() {
        return finalUrl;
    }

    public static class Builder {

        String endPoint = "";
        String extraQueryParams = "";


        public Builder endPoint(String iEndPoint) {
            this.endPoint = iEndPoint;
            return this;
        }

        public Builder addQuerParams(String iQueryParam) {
            this.extraQueryParams += iQueryParam;
            return this;
        }

        public ApiHelper build() {
            return new ApiHelper(this);
        }

    }

    private ApiHelper(Builder builder) {
        this.endPoint = builder.endPoint;
        this.finalUrl = finalUrl + Constants.BASE_URL;
        if (!TextUtils.isEmpty(endPoint)) {
            this.finalUrl = finalUrl + endPoint;
        }
        if (!TextUtils.isEmpty((extraQueryParams))) {
            this.finalUrl += extraQueryParams;
        }
    }

}
