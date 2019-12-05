package com.example.country.helper;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUtil {

    private static String TAG = NetworkUtil.class.getSimpleName();
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

    public static void showNetworkDialog(Context context,String message,String title)
    {
        try {
            AlertDialog dialog = new AlertDialog.Builder(context).create();
            dialog.setTitle(title);
            dialog.setMessage(message);
            dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Try Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

        }catch (Exception e)
        {
            Log.d(TAG,e.getMessage());
        }
    }

}
