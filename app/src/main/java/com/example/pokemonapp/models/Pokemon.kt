package com.example.pokemonapp.models

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String,
    val weight: Int,
    val height: Int,

    val sprites: Sprites,
    val abilities: List<Abilities>
)

data class Sprites(
    @SerializedName("front_default") val frontDefault: String, // serialized name is the label in the API
)

data class Abilities(
    @SerializedName("is_hidden") val isHidden: Boolean,
    val slot: Int,

    val ability: Ability
)

data class Ability (
    val name: String
)