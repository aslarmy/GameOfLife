package com.asl.childedu

import android.app.Application
import com.asl.childedu.di.initKoin
import org.koin.dsl.module

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin{
            it.modules(
                module {
                    single {
                        this@BaseApplication.applicationContext
                    }
                }
            )
        }
    }
}