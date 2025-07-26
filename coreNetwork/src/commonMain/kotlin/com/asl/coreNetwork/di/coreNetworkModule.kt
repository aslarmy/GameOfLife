package com.asl.coreNetwork.di

import com.asl.coreNetwork.apiService.ApiService
import com.asl.coreNetwork.client.KtorClient
import org.koin.dsl.module


fun getCoreNetworkModule() = module {
    single { ApiService(httpClient = KtorClient.getInstance()) }
}