package com.asl.favourite.domain.useCases

import com.asl.favourite.domain.repository.FavouriteRepository

class UpsertUseCase(private val favouriteRepository: FavouriteRepository) {

    suspend operator fun invoke(id: Int, image: String, name: String) =
        favouriteRepository.upsert(id = id, image = image, name = name)

}