package com.asl.coreDatabase

import app.cash.sqldelight.db.SqlDriver

expect class SqlDriverFactory(context: Any? = null) {
    fun getSqlDriver(): SqlDriver
}