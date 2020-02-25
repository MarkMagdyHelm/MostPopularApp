//package com.example.mostpopularapp.ui.mplist.view
//
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.widget.Button
//import android.widget.ImageView
//import android.widget.TextView
//import butterknife.BindView
//import butterknife.ButterKnife
//import com.example.mondiatask.R
//import com.example.mondiatask.data.network.local.pojo.MusicApiRespons
//import com.google.gson.Gson
//
//class AppDetails : AppCompatActivity() {
//    @JvmField
//    @BindView(R.id.thumb_img)
//    var thumbImg: ImageView? = null
//    @JvmField
//    @BindView(R.id.title_text)
//    var titleText: TextView? = null
//    @JvmField
//    @BindView(R.id.seeall1)
//    var seeall1: Button? = null
//    @JvmField
//    @BindView(R.id.desctxt1)
//    var desctxt1: TextView? = null
//    @JvmField
//    @BindView(R.id.sourcetxt)
//    var sourcetxt: TextView? = null
//    @JvmField
//    @BindView(R.id.seeall)
//    var seeall: Button? = null
//    @JvmField
//    @BindView(R.id.desctxt)
//    var desctxt: TextView? = null
//    @JvmField
//    @BindView(R.id.descsecondtxt)
//    var descsecondtxt: TextView? = null
//    @JvmField
//    @BindView(R.id.url)
//    var url: TextView? = null
//    @JvmField
//    @BindView(R.id.date)
//    var date: TextView? = null
//    var musicApiRespons: MusicApiRespons? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_music_details)
//        ButterKnife.bind(this)
//        //Get Obj String from bundle
//        val extras = intent.extras
//        val objString = extras.getString("obj")
//        //initalize screen with data
//        initScreen(objString)
//    }
//
//    fun initScreen(obj: String?) {
//        val gson = Gson()
//        musicApiRespons = gson.fromJson(obj, MusicApiRespons::class.java)
//        //        titleText.setText(musicApiRespons.title);
////        date.setText(musicApiRespons.publishingDate);
////        sourcetxt.setText(musicApiRespons.mainArtist.name);
////        descsecondtxt.setText(musicApiRespons.mainArtist.name);
////        Picasso.with(this).load("https:" + musicApiRespons.cover.small).into(thumbImg);
//    }
//}