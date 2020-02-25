package com.example.mostpopularapp.data.remote

import com.example.mostpopularapp.data.remote.endpoints.MostPopularApiInterface
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import com.example.mostpopularapp.utilities.Consts
import io.reactivex.Single


class NetworkApifunctions private constructor() {

    companion object {
        private var INSTANCE: NetworkApifunctions? = null
        val instance: NetworkApifunctions?
            get() {
                if (INSTANCE == null) {
                    if (INSTANCE == null) {
                        INSTANCE = NetworkApifunctions()
                    }
                }
                return INSTANCE
            }
    }

    fun getList(num: Int): Single<MostPopularResponseObj> {
        val apiService = ApiClient.createService(
            MostPopularApiInterface::class.java
        )
        return apiService.mostPopularList(Consts.BASE_URL+num+".json",Consts.API_KEY)
    }
}