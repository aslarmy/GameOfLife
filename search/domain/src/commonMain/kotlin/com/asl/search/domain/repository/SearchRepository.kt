package com.asl.search.domain.repository

import com.asl.common.domain.model.Game

interface SearchRepository {
    suspend fun search(q: String): Result<List<Game>>
}