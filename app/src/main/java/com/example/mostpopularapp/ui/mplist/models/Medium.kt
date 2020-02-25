package com.example.mostpopularapp.ui.mplist.models

import com.google.gson.annotations.SerializedName

class Medium {
    @SerializedName("approved_for_syndication")
    var approvedForSyndication: Long? = null
    @SerializedName("caption")
    var caption: String? = null
    @SerializedName("copyright")
    var copyright: String? = null
    @SerializedName("media-metadata")
    var mediaMetadata: List<MediaMetadatum>? = null
    @SerializedName("subtype")
    var subtype: String? = null
    @SerializedName("type")
    var type: String? = null

}