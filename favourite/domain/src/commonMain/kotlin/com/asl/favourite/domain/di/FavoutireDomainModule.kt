package com.asl.favourite.domain.di

import com.asl.favourite.domain.useCases.DeleteUseCase
import com.asl.favourite.domain.useCases.GetAllLocalCacheGamesUseCase
import com.asl.favourite.domain.useCases.UpsertUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getFavouriteDomainModule(): Module {
    return module {
        factory { DeleteUseCase(get()) }
        factory { GetAllLocalCacheGamesUseCase(get()) }
        factory { UpsertUseCase(get()) }
    }
}