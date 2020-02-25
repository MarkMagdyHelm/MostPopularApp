package com.example.mostpopularapp.ui.mplist

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.mostpopularapp.ui.base.BaseViewModel
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj

class ItemsViewModel(application: Application) :
    BaseViewModel<Any?>(application) {
    private var mRepository: ItemsRepository = ItemsRepository()

    fun getSubjects(appsId: Int) {
        mRepository.getSubjects(appsId)
    }
    fun getAppsCallback(): MutableLiveData<MostPopularResponseObj> {
        return mRepository.mpResponse
    }
}