package com.clcmo.modularizatedapp.di

import com.clcmo.modularizatedapp.feature.list.AndroidJobListViewModel
import com.clcmo.modularizatedapp.feature.list.AndroidJobsAdapter
import com.clcmo.modularizatedapp.feature.main.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel() }

    viewModel {
        AndroidJobListViewModel(
            jobsUseCase = get()
        )
    }
}