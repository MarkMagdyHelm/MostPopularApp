package com.example.mostpopularapp.ui.mplist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mostpopularapp.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.example.mostpopularapp.ui.mplist.models.Result
import kotlinx.android.synthetic.main.activity_app_details.*

class AppDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_details)
        //Get Obj String from bundle
        val extras = intent.extras
        val objString = extras?.getString("obj")
        //initalize screen with data
        initScreen(objString)
    }
    fun initScreen(obj: String?) {
        val gson = Gson()
       val  appDetails = gson.fromJson(obj, Result::class.java)
        txttitle.text = appDetails.nytdsection
        txtdisc.text = appDetails.adxKeywords
        when {
            (appDetails.media!!.isNotEmpty() && appDetails.media!!.get(0).mediaMetadata!!.isNotEmpty()) ->
        Picasso.get().load( appDetails.media!!.get(0).mediaMetadata!!.get(0).url).into(appimage)
    }}
}
