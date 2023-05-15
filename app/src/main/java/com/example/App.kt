package com.example

import android.app.Application
import com.example.common.NetworkModule
import com.example.main_page.di.CurrencyModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
        setupKoin()
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }

    private fun setupKoin() {
        GlobalContext.stopKoin()
        GlobalContext.startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    NetworkModule.create(),
                    CurrencyModule.create(),
                )
            )
        }
    }
}