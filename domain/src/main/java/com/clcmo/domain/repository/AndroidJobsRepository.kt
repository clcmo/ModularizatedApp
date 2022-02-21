package com.clcmo.domain.repository

import com.clcmo.domain.entities.AndroidJob
import io.reactivex.Observable
import io.reactivex.Single

interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>>
}