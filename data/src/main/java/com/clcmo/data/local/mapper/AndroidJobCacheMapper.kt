package com.clcmo.data.local.mapper

import com.clcmo.data.local.model.AndroidJobCache
import com.clcmo.domain.entities.AndroidJob

object AndroidJobCacheMapper {

    fun map(cacheData: List<AndroidJobCache>) = cacheData.map { map(it) }

    private fun map(cacheData: AndroidJobCache) = AndroidJob(
        title = cacheData.title,
        experienceTimeRequired = cacheData.requiredExperienceYears,
        native = cacheData.native,
        country = cacheData.country
    )

    fun mapJobsToCache(jobs: List<AndroidJob>) = jobs.map { map(it) }

    private fun map(data: AndroidJob) = AndroidJobCache(
        title = data.title,
        requiredExperienceYears = data.experienceTimeRequired,
        native = data.native,
        country = data.country
    )
}