package com.clcmo.domain.uc

import com.clcmo.domain.entities.AndroidJob
import com.clcmo.domain.repository.AndroidJobsRepository
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single

class GetJobsUseCases(
    private val repository: AndroidJobsRepository,
    private val scheduler: Scheduler
) {

    fun execute(forceUpdate: Boolean): Single<List<AndroidJob>> =
        repository.getJobs(forceUpdate)
            .subscribeOn(scheduler)
}