package com.clcmo.data.remote.mapper

import com.clcmo.data.remote.model.AndroidJobPayload
import com.clcmo.data.remote.model.JobsPayload
import com.clcmo.domain.entities.AndroidJob

object AndroidJobMapper {

    fun map(payload: JobsPayload) = payload.jobsPayload.map { map(it) }

    private fun map(payload: AndroidJobPayload) = AndroidJob(
        title = payload.title,
        experienceTimeRequired = payload.requiredExperienceYears,
        native = payload.native,
        country = payload.country
    )
}

