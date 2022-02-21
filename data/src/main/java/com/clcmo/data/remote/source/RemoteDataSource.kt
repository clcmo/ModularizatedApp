package com.clcmo.data.remote.source

import com.clcmo.data.remote.model.JobsPayload
import com.clcmo.domain.responses.ResultRemote

interface RemoteDataSource {
    suspend fun getJobs(): ResultRemote<JobsPayload>
}