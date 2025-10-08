package com.example.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import com.example.pokemonapp.ui.screens.SearchPokemon
import com.example.pokemonapp.ui.theme.PokemonAppTheme

class MainActivity : ComponentActivity() {

    // Store view model in MainActivity
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonAppTheme {
                SearchPokemon(mainViewModel)
            }
        }
    }
}


