package com.example.pokemonapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pokemonapp.MainViewModel
import com.example.pokemonapp.R

@Composable
fun SearchPokemon(mainViewModel: MainViewModel) {

    // Get the pokemon object from stateflow
    val pokemon by mainViewModel.pokemon.collectAsState()

        // Store the text input
        var text by remember { mutableStateOf("") }

        // Display Search Form
        Row()
        {
            // Pokemon search form

            TextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                }
            )

            Button(
                onClick = {
                    mainViewModel.searchPokemon( name = text)
                }
            )
            {
                Text("Search Pokemon")
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {


            // Pokemon props
            if(pokemon != null) {
                Text(text = pokemon?.name.toString(), style = MaterialTheme.typography.titleLarge)

                Text(
                    text = "Weight: " + pokemon?.weight.toString() + "lbs",
                    style = MaterialTheme.typography.titleSmall
                )

                Text(
                    text = "Height: " + pokemon?.height.toString() + "ft",
                    style = MaterialTheme.typography.titleSmall
                )

                // Sprites

                Image(
                    painter = rememberAsyncImagePainter(pokemon?.sprites?.frontDefault),
                    contentDescription = "Pokemon Sprite",
                    modifier = Modifier.size(128.dp)
                )

                // Abilities

                Text("Abilities:", style = MaterialTheme.typography.titleSmall)

                for (item in pokemon?.abilities!!) {
                    Text(item.ability.name)
                }
            }
        }

}