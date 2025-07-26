package com.asl.search.data.di

import com.asl.search.data.repository.SearchRepositoryImpl
import com.asl.search.domain.repository.SearchRepository
import org.koin.dsl.module

fun getSearchDataModule() = module {
    factory<SearchRepository> { SearchRepositoryImpl(apiService = get()) }
}