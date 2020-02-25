package com.example.mostpopularapp.application
import android.content.Context
import android.app.Application

import android.util.Log

class application : Application() {
    override fun attachBaseContext(base: Context) { //        super.attachBaseContext(LocaleHelper.onAttach(base, "ar"));
    }

    fun error(tag: String?, error_no: Int, msg: String) {
        Log.e(tag, "$msg $error_no")
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        //        FirebaseApp.initializeApp(this);
    }

    companion object {
        /**
         * Get an instance of application
         *
         * @return
         */
        @get:Synchronized
        var instance: application? = null
            private set

        fun context(): Context {
            return instance!!.applicationContext
        }
    }
}