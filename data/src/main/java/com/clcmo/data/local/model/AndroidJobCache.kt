package com.clcmo.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobs")
data class AndroidJobCache(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String = "",
    var requiredExperienceYears: String = "",
    var native: Boolean = true,
    var country: String = ""
)