package com.clcmo.data.remote.source

import com.clcmo.data.extensions.mapRemoteErrors
import com.clcmo.data.remote.api.ServerApi
import com.clcmo.data.remote.mapper.AndroidJobMapper
import com.clcmo.data.remote.model.JobsPayload
import com.clcmo.domain.entities.AndroidJob
import com.clcmo.domain.responses.ResultRemote
import io.reactivex.Single

class RemoteDataSourceImpl(
    private val serverApi: ServerApi
): RemoteDataSource {

    override suspend fun getJobs(): ResultRemote<JobsPayload> = try {
        val jobsPayload = serverApi.fetchJobs()

        ResultRemote.Success(
            response = jobsPayload
        )
    } catch (throwable: Throwable) {
        throwable.mapRemoteErrors()
    }
}