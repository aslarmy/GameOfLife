package com.asl.game.domain.usecases

import com.asl.game.domain.repository.GameRepository

class DeleteUseCase(private val gameRepository: GameRepository) {

    suspend operator fun invoke(id: Int) = gameRepository.delete(id)

}