package com.noox.checklist

import com.noox.checklist.core.di.appModule
import com.noox.checklist.superzings.di.superZingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin()
    }

    private fun startKoin() {
        startKoin {
            androidContext(this@Application)
            androidLogger()
            modules(listOf(appModule, superZingsModule))
        }
    }
}