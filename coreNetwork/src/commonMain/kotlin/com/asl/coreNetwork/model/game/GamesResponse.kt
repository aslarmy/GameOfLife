package com.asl.coreNetwork.model.game

import kotlinx.serialization.Serializable

@Serializable
data class GamesResponse(
    val results: List<Result>
)