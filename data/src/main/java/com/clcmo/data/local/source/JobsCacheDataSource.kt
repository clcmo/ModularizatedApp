package com.clcmo.data.local.source

import com.clcmo.domain.entities.AndroidJob
import io.reactivex.Single

interface JobsCacheDataSource {
    fun getJobs(): Single<List<AndroidJob>>

    fun insertData(list: List<AndroidJob>)
    fun updateData(list: List<AndroidJob>)
}

