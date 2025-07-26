package com.asl.game.data.mappers

import com.asl.game.domain.model.Developer
import com.asl.game.domain.model.GameDetails
import com.asl.game.domain.model.Platform
import com.asl.game.domain.model.Store
import com.asl.game.domain.model.Tag
import com.asl.coreNetwork.model.gameDetails.GameDetailsResponse

fun GameDetailsResponse.toDomainGameDetails(): GameDetails {

    return GameDetails(
        name = name,
        id = id,
        description = description,
        backgroundImage = background_image,
        additionalImage = background_image_additional ?: "",
        platforms = platforms.map {
            Platform(
                name = it.platform.name,
                image = it.platform.image_background
            )
        },
        stores = stores.map {
            Store(
                name = it.store.name,
                image = it.store.image_background,
                gameCount = it.store.games_count,
                domain = it.store.domain
            )
        },
        developers = developers.map {
            Developer(
                name = it.name,
                image = it.image_background,
                gameCount = it.games_count
            )
        },
        tags = tags.map {
            Tag(
                name = it.name,
                image = it.image_background
            )
        }
    )

}