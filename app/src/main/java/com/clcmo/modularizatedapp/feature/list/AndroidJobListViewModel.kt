package com.clcmo.modularizatedapp.feature.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clcmo.domain.entities.AndroidJob
import com.clcmo.domain.uc.GetJobsUseCases
import com.clcmo.modularizatedapp.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AndroidJobListViewModel(
    private val jobsUseCase: GetJobsUseCases
): ViewModel() {


    private val _viewJobsStatesLiveData = MutableLiveData<Event<ViewJobsStates>>()
    val viewJobsStatesLiveData: LiveData<Event<ViewJobsStates>> = _viewJobsStatesLiveData

    fun getJobs() {
        viewModelScope.launch(Dispatchers.IO) {
            jobsUseCase.getJobs().collect {
                val resultJobs = when(it) {
                    is GetJobsUseCases.ResultJobs.Jobs -> ViewJobsStates.Show(it.list)
                    GetJobsUseCases.ResultJobs.NoJobs -> ViewJobsStates.Empty
                    GetJobsUseCases.ResultJobs.Error -> ViewJobsStates.Error
                }

                _viewJobsStatesLiveData.postValue(Event(resultJobs))
            }
        }
    }

    fun add() {
        viewModelScope.launch(Dispatchers.IO) {
            jobsUseCase.addJob()
        }
    }

    fun onTryAgainRequired() {
        getJobs()
    }

    sealed class ViewJobsStates {
        data class Show(val list: List<AndroidJob>): ViewJobsStates()
        object Empty: ViewJobsStates()
        object Error: ViewJobsStates()
    }
}