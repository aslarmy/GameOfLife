package com.asl.search.data.repository

import com.asl.common.data.mappers.toDomainListOfGames
import com.asl.common.domain.model.Game
import com.asl.coreNetwork.apiService.ApiService
import com.asl.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val apiService: ApiService
) : SearchRepository {
    override suspend fun search(q: String): Result<List<Game>> {
        return try {
            val response = apiService.search(q)
            val data = response.getOrThrow().results.toDomainListOfGames()
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}