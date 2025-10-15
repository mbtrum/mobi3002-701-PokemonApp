package com.example.pokemonapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.models.Abilities
import com.example.pokemonapp.models.Ability
import com.example.pokemonapp.models.Pokemon
import com.example.pokemonapp.models.Sprites
import com.example.pokemonapp.services.PokemonService
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    // Pokemon model
    private val _pokemon = MutableStateFlow<Pokemon?>(null)
    val pokemon = _pokemon.asStateFlow()

    // Retrofit instance
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Initialize interface service
    val pokemonService: PokemonService = retrofit.create(PokemonService::class.java)

//    init {
//        Make API call inside a co-routine (async)
//        viewModelScope.launch {
//
//            // fetch pokemon character from API
//            //val pokemon = pokemonService.getPokemon()
//
//            //_pokemon.value = pokemon
//        }
//    }

    fun searchPokemon(name: String){
        viewModelScope.launch {
            // fetch pokemon character from API by name
            val pokemon = pokemonService.getPokemon(name)

            _pokemon.value = pokemon
        }
    }

}