package com.clcmo.data.local.source

import com.clcmo.data.local.database.JobsDAO
import com.clcmo.data.local.mapper.AndroidJobCacheMapper
import com.clcmo.data.local.model.AndroidJobCache
import com.clcmo.domain.entities.AndroidJob
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

class JobsCacheSourceImpl(private val jobsDao: JobsDAO): JobsCacheDataSource {

    override fun getJobs(): Flow<List<AndroidJobCache>> = jobsDao.getJobs()

    override fun insertData(jobCache: AndroidJobCache) {
        jobsDao.insert(jobCache)
    }

    override fun updateData(cacheList: List<AndroidJobCache>) {
        jobsDao.updateData(cacheList)
    }
}