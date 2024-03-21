package colombiadex.presentation.mascotas

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import colombiadex.core.Constants.Companion.MASCOTAS_SCREEN
import colombiadex.presentation.mascotas.components.AddPokemonAlertDialog
import colombiadex.presentation.mascotas.components.AddPokemonFloatingActionButton
import colombiadex.presentation.mascotas.components.PokemonsContent

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