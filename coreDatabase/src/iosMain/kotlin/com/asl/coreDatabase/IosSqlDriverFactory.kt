package com.asl.coreDatabase

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.asl.sqldelight.AppDatabase

actual class SqlDriverFactory actual constructor(context: Any?) {

    actual fun getSqlDriver(): SqlDriver {
        return NativeSqliteDriver(
            AppDatabase.Schema,
            "AppDatabase.db"
        )
    }
}