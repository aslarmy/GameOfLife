package com.asl.coreNetwork.apiService

import com.asl.coreNetwork.model.game.GamesResponse
import com.asl.coreNetwork.model.gameDetails.GameDetailsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(val httpClient: HttpClient) {

    // //https://api.rawg.io/api/games?key=9e8a2c8eba494542b3121a2e4f05199e
    suspend fun getGames(): Result<GamesResponse> {
        return try {
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "9e8a2c8eba494542b3121a2e4f05199e")
                }
            }.body<GamesResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun search(q: String): Result<GamesResponse> {
        return try {
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "9e8a2c8eba494542b3121a2e4f05199e")
                    parameter("search", q)
                }
            }.body<GamesResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    //https://api.rawg.io/api/games/3498?key=9e8a2c8eba494542b3121a2e4f05199e
    suspend fun getDetails(id: Int): Result<GameDetailsResponse> {
        return try {
            val response = httpClient.get("api/games/${id}")
            {
                parameter("key", "9e8a2c8eba494542b3121a2e4f05199e")
            }.body<GameDetailsResponse>()

            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}