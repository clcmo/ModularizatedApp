package com.clcmo.modularizatedapp.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.clcmo.modularizatedapp.feature.vm.BaseViewModel
import com.clcmo.modularizatedapp.utils.Event

class MainViewModel: BaseViewModel() {

    private val _mainActionLiveData = MutableLiveData<Event<MainAction>>()
    val mainActionLiveData: LiveData<Event<MainAction>> = _mainActionLiveData

    fun onShowAndroidJobsRequire() {
        _mainActionLiveData.postValue(Event(MainAction.SHOW_JOBS))
    }

    fun onOutAppLiveData() {
        _mainActionLiveData.postValue(Event(MainAction.LEAVE_APP))
    }
}

sealed class MainAction {
    object SHOW_JOBS: MainAction()
    object LEAVE_APP: MainAction()
}