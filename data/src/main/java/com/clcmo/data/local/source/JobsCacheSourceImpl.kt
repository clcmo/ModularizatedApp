package com.clcmo.data.local.source

import com.clcmo.data.local.database.JobsDAO
import com.clcmo.data.local.mapper.AndroidJobCacheMapper
import com.clcmo.domain.entities.AndroidJob
import io.reactivex.Single

class JobsCacheSourceImpl(private val jobsDao: JobsDAO): JobsCacheDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return jobsDao.getJobs()
            .map { AndroidJobCacheMapper.map(it) }
    }

    override fun insertData(list: List<AndroidJob>) {
        jobsDao.insertAll(AndroidJobCacheMapper.mapJobsToCache(list))
    }

    override fun updateData(list: List<AndroidJob>) {
        jobsDao.updateData(AndroidJobCacheMapper.mapJobsToCache(list))
    }
}