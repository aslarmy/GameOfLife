package com.asl.favourite.domain.useCases

import com.asl.favourite.domain.repository.FavouriteRepository

class GetAllLocalCacheGamesUseCase(
    private val favouriteRepository: FavouriteRepository
) {
    operator fun invoke() = favouriteRepository.getAllGames()
}