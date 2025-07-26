package com.asl.childedu.di

import com.asl.coreDatabase.di.getCoreDatabaseModule
import com.asl.coreNetwork.di.getCoreNetworkModule
import com.asl.favourite.data.di.getFavouriteDataModule
import com.asl.favourite.domain.di.getFavouriteDomainModule
import com.asl.favourite.ui.di.getFavouriteUiModule
import com.asl.game.data.di.getGameDataModule
import com.asl.game.domain.di.getGameDomainModule
import com.asl.game.ui.di.getGameUiModule
import com.asl.search.data.di.getSearchDataModule
import com.asl.search.domain.di.getSearchDomainModule
import com.asl.search.ui.di.getSearchUiModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        koinApplication?.invoke(this)
        modules(
            getCoreNetworkModule(),
            getGameDataModule(),
            getGameDomainModule(),
            getGameUiModule(),
            getSearchDataModule(),
            getSearchDomainModule(),
            getSearchUiModule(),
            getCoreDatabaseModule(),
            getFavouriteDataModule(),
            getFavouriteDomainModule(),
            getFavouriteUiModule()
        )
    }
}