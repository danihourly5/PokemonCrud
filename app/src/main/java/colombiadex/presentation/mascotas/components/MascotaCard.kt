package colombiadex.presentation.mascotas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import colombiadex.domain.model.Pokemon

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonCard(
    pokemon: Pokemon,
    deletePokemon: () -> Unit,
    navigateToUpdatePokemonScreen: (pokemonId: Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdatePokemonScreen(pokemon.id)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(pokemon.nombre)
                Text(pokemon.superpoder)
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deletePokemon = deletePokemon
            )
        }
    }
}