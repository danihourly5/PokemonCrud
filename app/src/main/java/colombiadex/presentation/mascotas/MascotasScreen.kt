package colombiadex.presentation.mascotas

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import colombiadex.core.Constants.Companion.POKEMON_SCREEN
import colombiadex.presentation.mascotas.components.AddPokemonAlertDialog
import colombiadex.presentation.mascotas.components.AddPokemonFloatingActionButton
import colombiadex.presentation.mascotas.components.PokemonsContent

@Composable
fun PokemonsScreen(
    viewModel: PokemonsViewModel = hiltViewModel(),
    navigateToUpdatePokemonScreen: (pokemonId: Int) -> Unit
) {
    val pokemons by viewModel.pokemons.collectAsState(
        initial = emptyList()
    )
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(POKEMON_SCREEN)
            })
        },
        content = { padding ->
            PokemonsContent(
                padding = padding,
                pokemons = pokemons,
                deletePokemon = { pokemon ->
                    viewModel.deletePokemon(pokemon)
                },
                navigateToUpdatePokemonScreen =
                navigateToUpdatePokemonScreen
            )
            AddPokemonAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addPokemon = { pokemon ->
                    viewModel.addPokemon(pokemon)
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