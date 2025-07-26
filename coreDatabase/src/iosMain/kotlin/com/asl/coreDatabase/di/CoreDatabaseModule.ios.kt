package com.asl.coreDatabase.di

import app.cash.sqldelight.db.SqlDriver
import com.asl.coreDatabase.SqlDriverFactory
import com.asl.sqldelight.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun getCoreDatabaseModule(): Module {
    return module {
        single {
            SqlDriverFactory().getSqlDriver()
        }
        single { AppDatabase.invoke(get<SqlDriver>()) }
    }
}