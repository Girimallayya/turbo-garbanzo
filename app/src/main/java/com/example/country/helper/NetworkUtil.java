package com.example.country.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUtil {

    public static String TAG = NetworkUtil.class.getSimpleName();
    private static boolean mConnected = false;


    public static boolean isOnline(Context context)
    {
        try
        {
            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            mConnected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            return mConnected;

        }catch (Exception e)
        {
            Log.d(TAG,e.getMessage());
        }
        return mConnected;
    }

}
