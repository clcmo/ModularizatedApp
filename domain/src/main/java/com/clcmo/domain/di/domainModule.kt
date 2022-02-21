package com.clcmo.domain.di

import com.clcmo.domain.uc.GetJobsUseCases
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module


val useCaseModule = module {

    factory {
        GetJobsUseCases(
            repository = get(),
            scheduler = Schedulers.io()
        )
    }
}

val domainModule = listOf(useCaseModule)