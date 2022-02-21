package com.clcmo.domain.repository

import com.clcmo.domain.entities.AndroidJob
import com.clcmo.domain.responses.ResultRequired
import kotlinx.coroutines.flow.Flow

interface AndroidJobsRepository {
    fun getJobs(): Flow<ResultRequired<List<AndroidJob>>>
    fun add()
}