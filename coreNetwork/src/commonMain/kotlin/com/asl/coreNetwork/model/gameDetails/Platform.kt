package com.asl.coreNetwork.model.gameDetails

import kotlinx.serialization.Serializable

@Serializable

data class Platform(
    val id: Int,
    val name: String,
    val slug: String
)