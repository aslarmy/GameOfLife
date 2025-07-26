package com.asl.favourite.data.di

import com.asl.favourite.data.repository.FavouriteRepositoryImpl
import com.asl.favourite.domain.repository.FavouriteRepository
import com.asl.sqldelight.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getFavouriteDataModule(): Module {
    return module {
        factory<FavouriteRepository> {
            FavouriteRepositoryImpl(get<AppDatabase>())
        }
    }
}