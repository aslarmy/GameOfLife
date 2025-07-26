package com.asl.coreNetwork.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    fun getInstance(): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = Json {
                ignoreUnknownKeys = true
            })
        }

        //https://api.rawg.io/api/games?key=9e8a2c8eba494542b3121a2e4f05199e
        install(DefaultRequest) {
            url {
                host = "api.rawg.io"
                protocol = URLProtocol.HTTPS
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 1000 * 60 * 2
            connectTimeoutMillis = 1000 * 60 * 2
            requestTimeoutMillis = 1000 * 60 * 2
        }

    }


}