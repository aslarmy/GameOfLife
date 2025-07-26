package com.asl.favourite.ui.di

import com.asl.favourite.ui.FavouriteViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getFavouriteUiModule(): Module {
    return module {
        viewModel {
            FavouriteViewModel(
                gtAllLocalCacheGamesUseCase = get(),
                deleteUseCase = get()
            )
        }
    }
}