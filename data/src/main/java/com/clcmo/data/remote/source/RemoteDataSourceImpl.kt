package com.clcmo.data.remote.source

import com.clcmo.data.remote.api.ServerApi
import com.clcmo.data.remote.mapper.AndroidJobMapper
import com.clcmo.domain.entities.AndroidJob
import io.reactivex.Single

class RemoteDataSourceImpl(private val serverApi: ServerApi):
    RemoteDataSource {

    override fun getJobs(): Single<List<AndroidJob>> = serverApi.fetchJobs()
        .map { AndroidJobMapper.map(it) }
}