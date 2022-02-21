package com.clcmo.domain.uc

import com.clcmo.domain.entities.AndroidJob
import kotlinx.coroutines.flow.Flow

interface GetJobsUseCases{
    fun getJobs(): Flow<ResultJobs>
    fun addJob()

    sealed class ResultJobs {
        data class Jobs(val list: List<AndroidJob>): ResultJobs()
        object NoJobs: ResultJobs()
        object Error: ResultJobs()
    }
}