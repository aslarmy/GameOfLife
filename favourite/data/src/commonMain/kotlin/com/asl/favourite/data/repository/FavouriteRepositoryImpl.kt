package com.asl.favourite.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.asl.common.domain.model.Game
import com.asl.favourite.domain.repository.FavouriteRepository
import com.asl.sqldelight.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FavouriteRepositoryImpl(
    private val appDatabase: AppDatabase
) : FavouriteRepository {
    override fun getAllGames(): Flow<List<Game>> {
        return appDatabase.appDatabaseQueries
            .getAllGames()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map {
                it.map { item ->
                    Game(
                        id = item.id.toInt(),
                        name = item.name,
                        imageUrl = item.image
                    )
                }
            }
    }

    override suspend fun upsert(id: Int, name: String, image: String) {
        appDatabase.appDatabaseQueries
            .upsert(id.toLong(), name, image)
    }

    override suspend fun delete(id: Int) {
        appDatabase.appDatabaseQueries
            .delete(id.toLong())
    }
}