package com.asl.search.domain.di

import com.asl.search.domain.useCases.SearchGameUseCase
import org.koin.dsl.module

fun getSearchDomainModule() = module {
    factory { SearchGameUseCase(get()) }
}