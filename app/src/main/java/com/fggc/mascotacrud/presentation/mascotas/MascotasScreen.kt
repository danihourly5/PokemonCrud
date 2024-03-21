package com.fggc.mascotacrud.presentation.mascotas

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTAS_SCREEN
import com.fggc.mascotacrud.presentation.mascotas.components.AddPokemonAlertDialog
import com.fggc.mascotacrud.presentation.mascotas.components.AddPokemonFloatingActionButton
import com.fggc.mascotacrud.presentation.mascotas.components.PokemonsContent

@Composable
fun PokemonsScreen(
    viewModel: PokemonsViewModel = hiltViewModel(),
    navigateToUpdatePokemonScreen: (mascotaId: Int) -> Unit
) {
    val mascotas by viewModel.mascotas.collectAsState(
        initial = emptyList()
    )
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(MASCOTAS_SCREEN)
            })
        },
        content = { padding ->
            PokemonsContent(
                padding = padding,
                mascotas = mascotas,
                deletePokemon = { mascota ->
                    viewModel.deletePokemon(mascota)
                },
                navigateToUpdatePokemonScreen =
                navigateToUpdatePokemonScreen
            )
            AddPokemonAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addPokemon = { mascota ->
                    viewModel.addPokemon(mascota)
                }
            )
        },
        floatingActionButton = {
            AddPokemonFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}