package com.example.mostpopularapp.ui.mplist

import androidx.lifecycle.MutableLiveData
import com.example.mostpopularapp.data.remote.NetworkApifunctions.Companion.instance
import com.example.mostpopularapp.ui.mplist.models.MostPopularResponseObj
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ItemsRepository internal constructor() {
    var erorrHandling = MutableLiveData<Boolean>()
    @JvmField
    var mpResponse =
        MutableLiveData<MostPopularResponseObj>()
    private val disposables = CompositeDisposable()
    fun getSubjects(appsId: Int) {
        val Functions = instance
        val disposable = Functions!!.getList(appsId)
            .subscribeOn(Schedulers.io())
            .subscribe({ subjectsResponseObj: MostPopularResponseObj -> getSubjectSucess(subjectsResponseObj) }
            ) { throwable: Throwable -> getSubjectError() }
        disposables.add(disposable)
    }

    private fun getSubjectError() {
        erorrHandling.value = true
    }

    private fun getSubjectSucess(subjectsResponseObj: MostPopularResponseObj) {
        erorrHandling.postValue( false)
        mpResponse.postValue(subjectsResponseObj)
    }

}