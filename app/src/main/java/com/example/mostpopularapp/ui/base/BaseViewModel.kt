package com.example.mostpopularapp.ui.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T> protected constructor(application: Application) :
    AndroidViewModel(application) {
    val liveData = MutableLiveData<T>()
    val errorMsg = MutableLiveData<String>()
    private val compositeDisposable = CompositeDisposable()
    //override when viewModel needed but no first api
    fun onCreate() {}

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}