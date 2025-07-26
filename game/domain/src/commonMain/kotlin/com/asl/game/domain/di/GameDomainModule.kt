package com.asl.game.domain.di

import com.asl.game.domain.usecases.DeleteUseCase
import com.asl.game.domain.usecases.GetGameDetailsUseCase
import com.asl.game.domain.usecases.GetGameUseCase
import com.asl.game.domain.usecases.SaveGameUseCase
import org.koin.dsl.module

fun getGameDomainModule() = module {
    factory { GetGameUseCase(gameRepository = get()) }
    factory { GetGameDetailsUseCase(gameRepository = get()) }
    factory { SaveGameUseCase(gameRepository = get()) }
    factory { DeleteUseCase(gameRepository = get()) }
}