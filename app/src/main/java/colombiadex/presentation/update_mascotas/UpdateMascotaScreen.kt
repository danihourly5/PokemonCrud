package colombiadex.presentation.update_mascotas

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import colombiadex.presentation.mascotas.PokemonsViewModel
import colombiadex.presentation.update_mascotas.components.UpdatePokemonContent
import colombiadex.presentation.update_mascotas.components.UpdatePokemonTopBar

@Composable
fun UpdatePokemonScreen(
    viewModel: PokemonsViewModel = hiltViewModel(),
    mascotaId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getPokemon(mascotaId)
    }
    Scaffold(
        topBar = {
            UpdatePokemonTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdatePokemonContent(
                padding = padding,
                mascota = viewModel.mascota,
                updateAnimal = { animal ->
                    viewModel.updateAnimal(animal)
                },
                updateRaza = { raza ->
                    viewModel.updateRaza(raza)
                },
                updatePokemon = { mascota ->
                    viewModel.updatePokemon(mascota)
                },
                navigateBack = navigateBack
            )
        }
    )
}