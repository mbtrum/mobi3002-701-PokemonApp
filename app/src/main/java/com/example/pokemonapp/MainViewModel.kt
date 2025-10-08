package com.example.pokemonapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.models.Abilities
import com.example.pokemonapp.models.Ability
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.models.Sprites
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    /* add properties, functions, etc. */

    private val _pokemon = MutableStateFlow<Pokemon?>(null)
    val pokemon = _pokemon.asStateFlow()

    init {
        /* perform any initialization */

        // Create Ditto
        val pokemon = Pokemon(
            name = "Ditto",
            weight = 40,
            height = 3,
            sprites = Sprites(
                front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png",
                resource_id = R.drawable.ditto
            ),
            abilities = listOf(
                Abilities(
                    is_hidden = false,
                    slot = 1,
                    ability = Ability(
                        name = "limber"
                    )
                ),
                Abilities(
                    is_hidden = true,
                    slot = 3,
                    ability = Ability(
                        name = "imposter"
                    )
                )
            )
        )

        // Set the value of the pokemon class variable
        _pokemon.value = pokemon

        // Change the pokemon value after 10 seconds
        viewModelScope.launch {
            delay(10000)

            // Create Ditto
            val pokemon = Pokemon(
                name = "Pikachu",
                weight = 60,
                height = 4,
                sprites = Sprites(
                    front_default = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
                    resource_id = R.drawable.pikachu
                ),
                abilities = listOf(
                    Abilities(
                        is_hidden = false,
                        slot = 1,
                        ability = Ability(
                            name = "static"
                        )
                    ),
                    Abilities(
                        is_hidden = true,
                        slot = 3,
                        ability = Ability(
                            name = "lightening rod"
                        )
                    )
                )
            )

            // Set the value of the pokemon class variable
            _pokemon.value = pokemon
        }
    }
}