package com.clcmo.domain.di

import com.clcmo.domain.uc.GetJobsUseCases
import com.clcmo.domain.uc.GetJobsUseCasesImpl
import io.reactivex.schedulers.Schedulers
import org.koin.dsl.module

val useCaseModule = module {

    factory<GetJobsUseCases> {
        GetJobsUseCasesImpl(
            repository = get()
        )
    }
}

val domainModule = listOf(useCaseModule)