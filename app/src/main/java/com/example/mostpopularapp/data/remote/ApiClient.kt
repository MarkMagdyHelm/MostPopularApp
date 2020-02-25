package com.example.mostpopularapp.data.remote

import com.example.mostpopularapp.utilities.Consts
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by elsdody on 11/28/2017.
 */
object ApiClient {
    const val API_BASE_URL = Consts.BASE_URL
    //   public static Context context= application.context();
    private const val cacheSize = 10 * 1024 * 1024 // 10 MB
    private val cache: Cache? = null
    private var retrofit: Retrofit? = null
    private val httpClient = OkHttpClient.Builder()
    fun <S> createService(
        serviceClass: Class<S>
    ): S {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder() // connect timeout
            .cache(cache)
            .addInterceptor(logging)
            .connectTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .addInterceptor { chain ->
                var request = chain.request()
                //                        if (CheckConnection.isNetworkAvailable(context)) {
                request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60)
                    .build()
                //                        } else {
//                            // Toast.makeText(context," Please Check your connection", Toast.LENGTH_LONG).show();
//                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
//                        }
                chain.proceed(request)
            }
            .build()

        return  Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(serviceClass)
    }
}