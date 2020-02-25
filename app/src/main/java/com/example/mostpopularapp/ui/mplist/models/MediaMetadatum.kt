package com.example.mostpopularapp.ui.mplist.models

import com.google.gson.annotations.SerializedName

class MediaMetadatum {
    @SerializedName("format")
    var format: String? = null
    @SerializedName("height")
    var height: Long? = null
    @SerializedName("url")
    var url: String? = null
    @SerializedName("width")
    var width: Long? = null

}