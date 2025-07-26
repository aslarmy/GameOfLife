package com.asl.favourite.domain.useCases

import com.asl.favourite.domain.repository.FavouriteRepository

class DeleteUseCase(private val favouriteRepository: FavouriteRepository) {

    suspend operator fun invoke(id: Int) =
        favouriteRepository.delete(id)
}