package com.asl.childedu

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.asl.childedu.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Child Edu",
    ) {
        initKoin()
        App()
    }
}