package com.example.mostpopularapp.data.remote

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by MarkMagdy on 05/11/2017.
 */
object CheckConnection {
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}