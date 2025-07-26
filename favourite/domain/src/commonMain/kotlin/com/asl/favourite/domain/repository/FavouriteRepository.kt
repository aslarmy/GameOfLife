package com.asl.favourite.domain.repository

import com.asl.common.domain.model.Game
import kotlinx.coroutines.flow.Flow

interface FavouriteRepository {

    fun getAllGames(): Flow<List<Game>>
    suspend fun upsert(id: Int, name: String, image: String)
    suspend fun delete(id: Int)

}