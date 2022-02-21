package com.clcmo.data.di

import com.clcmo.data.AndroidJobsRepositoryImpl
import com.clcmo.data.remote.source.RemoteDataSource
import com.clcmo.data.remote.source.RemoteDataSourceImpl
import com.clcmo.domain.repository.AndroidJobsRepository
import org.koin.dsl.module


val repositoryModule = module {
    factory<AndroidJobsRepository> {
        AndroidJobsRepositoryImpl(
            jobsCacheDataSource = get(),
            remoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)