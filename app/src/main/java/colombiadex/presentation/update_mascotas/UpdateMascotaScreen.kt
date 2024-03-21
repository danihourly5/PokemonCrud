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
    pokemonId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getPokemon(pokemonId)
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
                pokemon = viewModel.pokemon,
                updateNombre = { nombre ->
                    viewModel.updateNombre(nombre)
                },
                updateSuperPoder = { superpoder ->
                    viewModel.updateSuperPoder(superpoder)
                },
                updateGenero = { genero ->
                    viewModel.updateGenero(genero)
                },
                updateDescripcion = { descripcion ->
                    viewModel.updateDescripcion(descripcion)
                },
                updatePeso = { peso ->
                    viewModel.updatePeso(peso)
                },
                updateAltura = { altura ->
                    viewModel.updateAltura(altura)
                },
                updateCategoria = { categoria ->
                    viewModel.updateCategoria(categoria)
                },
                updatePokemon = { pokemon ->
                    viewModel.updatePokemon(pokemon)
                },
                navigateBack = navigateBack
            )
        }
    )
}