package com.clcmo.modularizatedapp

import android.app.Application
import com.clcmo.data.di.dataModules
import com.clcmo.domain.di.domainModule
import com.clcmo.modularizatedapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyModuleApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyModuleApplication)
            modules(dataModules + domainModule + listOf(presentationModule))
        }
    }
}