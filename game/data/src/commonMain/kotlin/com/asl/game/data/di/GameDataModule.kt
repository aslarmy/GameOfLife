package com.asl.game.data.di

import com.asl.game.data.repository.GameRepositoryImpl
import com.asl.game.domain.repository.GameRepository
import org.koin.dsl.module

fun getGameDataModule() = module {
    factory<GameRepository> {
        GameRepositoryImpl(
            apiService = get(),
            appDatabase = get()
        )
    }
}