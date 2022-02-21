package com.clcmo.data.local.source

import com.clcmo.data.local.model.AndroidJobCache
import kotlinx.coroutines.flow.Flow

interface JobsCacheDataSource {
    fun getJobs(): Flow<List<AndroidJobCache>>

    fun insertData(jobCache : AndroidJobCache)
    fun updateData(cacheList: List<AndroidJobCache>)
}