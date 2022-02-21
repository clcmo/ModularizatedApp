package com.clcmo.data

import com.clcmo.data.local.mapper.AndroidJobCacheMapper
import com.clcmo.data.local.source.JobsCacheDataSource
import com.clcmo.data.remote.mapper.AndroidJobMapper
import com.clcmo.data.remote.source.RemoteDataSource
import com.clcmo.domain.entities.AndroidJob
import com.clcmo.domain.repository.AndroidJobsRepository
import com.clcmo.domain.responses.ResultRemote
import com.clcmo.domain.responses.ResultRequired
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AndroidJobsRepositoryImpl(
    private val jobsCacheDataSource: JobsCacheDataSource,
    private val remoteDataSource: RemoteDataSource
): AndroidJobsRepository {

    override fun getJobs(): Flow<ResultRequired<List<AndroidJob>>> = jobsCacheDataSource.getJobs()
        .map { cacheList ->
            val result = when {
                cacheList.isEmpty() -> getJobsRemote()
                else -> {
                    val jobs = AndroidJobCacheMapper.map(cacheList)
                    ResultRequired.Success(jobs)
                }
            }
            result
        }

    override fun add() {
        val androidJob = AndroidJob(
            title = "flow",
            experienceTimeRequired = (0..500).random().toString(),
            native = true,
            country = "Brazil"
        )

        val cacheJob = AndroidJobCacheMapper.map(androidJob)
        jobsCacheDataSource.insertData(cacheJob)
    }

    private suspend fun getJobsRemote(): ResultRequired<List<AndroidJob>> =
        when(val resultRemote = remoteDataSource.getJobs()) {
            is ResultRemote.Success -> {
                val mappedList = AndroidJobMapper.map(resultRemote.response)
                val cacheList = AndroidJobCacheMapper.mapJobsToCache(mappedList)

                jobsCacheDataSource.updateData(cacheList)

                ResultRequired.Success(
                    result = mappedList
                )
            }
            is ResultRemote.ErrorResponse -> {
                ResultRequired.Error(resultRemote.throwable)
            }
        }
}