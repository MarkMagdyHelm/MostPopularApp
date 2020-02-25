package com.example.mostpopularapp.data.remote.endpoints

import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface MostPopularApiInterface {

    @GET
    fun mostPopularList(@Url url: String?, @Query("api-key") query: String?): Single<MostPopularResponseObj>
}
