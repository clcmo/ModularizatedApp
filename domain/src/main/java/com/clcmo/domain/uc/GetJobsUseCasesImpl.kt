package com.clcmo.domain.uc

import com.clcmo.domain.entities.AndroidJob
import com.clcmo.domain.repository.AndroidJobsRepository
import com.clcmo.domain.responses.ResultRequired
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetJobsUseCasesImpl(
    private val repository: AndroidJobsRepository
): GetJobsUseCases {

    override fun getJobs(): Flow<GetJobsUseCases.ResultJobs> = repository.getJobs()
        .map {
            when(it) {
                is ResultRequired.Success -> {
                    when {
                        it.result.isEmpty() -> GetJobsUseCases.ResultJobs.NoJobs
                        else -> GetJobsUseCases.ResultJobs.Jobs(it.result.reversed())
                    }
                }
                is ResultRequired.Error -> {
                    println(it.throwable.message)
                    GetJobsUseCases.ResultJobs.Error
                }
            }
        }

    override fun addJob() {
        repository.add()
    }
}