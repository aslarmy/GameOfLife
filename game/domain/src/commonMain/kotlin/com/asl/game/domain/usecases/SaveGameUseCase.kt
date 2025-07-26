package com.asl.game.domain.usecases

import com.asl.game.domain.repository.GameRepository

class SaveGameUseCase(
    private val gameRepository: GameRepository
) {

    suspend operator fun invoke(id: Int, image: String, name: String) = gameRepository.save(
        id = id,
        image = image,
        name = name
    )

}