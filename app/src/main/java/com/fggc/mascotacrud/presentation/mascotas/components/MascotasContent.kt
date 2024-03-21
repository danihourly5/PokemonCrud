package com.fggc.mascotacrud.presentation.mascotas.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fggc.mascotacrud.domain.model.Pokemon
import com.fggc.mascotacrud.domain.repository.Pokemons


@Composable
fun PokemonsContent(
    padding: PaddingValues,
    mascotas: Pokemons,
    deletePokemon: (mascota: Pokemon) -> Unit,
    navigateToUpdatePokemonScreen: (mascotaId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(mascotas) { mascota ->
            PokemonCard(
                mascota = mascota,
                deletePokemon = {
                    deletePokemon(mascota)
                },
                navigateToUpdatePokemonScreen =
                navigateToUpdatePokemonScreen
            )
        }
    }
}