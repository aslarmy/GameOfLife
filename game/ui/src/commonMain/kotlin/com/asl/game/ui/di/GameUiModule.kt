package com.asl.game.ui.di

import com.asl.game.ui.game.GameViewModel
import com.asl.game.ui.gameDetails.GameDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getGameUiModule() = module {
    viewModel { GameViewModel(getGameUseCase = get()) }
    viewModel {
        GameDetailsViewModel(
            getGameDetailsUseCase = get(),
            saveGameUseCase = get(),
            deleteUseCase = get()
        )
    }
}