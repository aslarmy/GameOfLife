package com.asl.common.data.mappers

import com.asl.common.domain.model.Game

fun List<com.asl.coreNetwork.model.game.Result>.toDomainListOfGames(): List<Game> = map {
    Game(
        id = it.id,
        name = it.name,
        imageUrl = it.background_image
    )
}