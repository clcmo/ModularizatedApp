package com.clcmo.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.clcmo.data.local.model.AndroidJobCache

@Database(version = 1, entities = [AndroidJobCache::class])
abstract class JobsDataBase : RoomDatabase() {
    abstract fun jobsDao(): JobsDAO

    companion object {
        fun createDataBase(context: Context) : JobsDAO = Room
            .databaseBuilder(context, JobsDataBase::class.java, "Jobs.db")
            .build()
            .jobsDao()
    }
}