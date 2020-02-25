package com.example.mostpopularapp.ui.mplist.models

import com.google.gson.annotations.SerializedName

class MostPopularResponseObj {
    @SerializedName("copyright")
    var copyright: String? = null
    @SerializedName("num_results")
    var numResults: Long? = null
    @SerializedName("results")
    var results: List<Result>? =
        null
    @SerializedName("status")
    var status: String? = null

}