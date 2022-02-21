package com.clcmo.data.di

import com.clcmo.data.local.database.JobsDataBase
import com.clcmo.data.local.source.JobsCacheDataSource
import com.clcmo.data.local.source.JobsCacheSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val cacheDataModule = module {
    single { JobsDataBase.createDataBase(androidContext()) }
    factory<JobsCacheDataSource> { JobsCacheSourceImpl(jobsDao = get()) }
}