package com.example.pokemonapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
//import coil3.compose.rememberAsyncImagePainter
import com.example.pokemonapp.MainViewModel
import com.example.pokemonapp.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SearchPokemon(mainViewModel: MainViewModel) {

    // Get the pokemon object from stateflow
    val pokemon by mainViewModel.pokemon.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ){
        // Pokemon props

        Text(text = pokemon?.name.toString(), style = MaterialTheme.typography.titleLarge)

        Text(text = pokemon?.weight.toString(), style = MaterialTheme.typography.titleSmall)

        Text(text = pokemon?.height.toString(), style = MaterialTheme.typography.titleSmall)

        // Sprites

        Image(
            painter = painterResource(id = pokemon?.sprites?.resource_id!!),
            contentDescription = "Pokemon Sprite",
            modifier = Modifier.size(128.dp)
        )

        // Abilities

        Text("Abilities:", style = MaterialTheme.typography.titleSmall)

        for(item in pokemon?.abilities!!){
            Text(item.ability.name)
        }
    }
}