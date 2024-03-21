package colombiadex.presentation.update_mascotas.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import colombiadex.core.Constants.Companion.ANIMAL
import colombiadex.core.Constants.Companion.RAZA
import colombiadex.core.Constants.Companion.UPDATE
import colombiadex.domain.model.Pokemon

@Composable
fun UpdatePokemonContent(
    padding: PaddingValues,
    mascota: Pokemon,
    updateAnimal: (animal: String) -> Unit,
    updateRaza: (raza: String) -> Unit,
    updatePokemon: (mascota: Pokemon) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = mascota.animal,
            onValueChange = { animal ->
                updateAnimal(animal)
            },
            placeholder = {
                Text(ANIMAL)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = mascota.raza,
            onValueChange = { raza ->
                updateRaza(raza)
            },
            placeholder = {
                Text(RAZA)
            }
        )
        Button(
            onClick = {
                updatePokemon(mascota)
                navigateBack()
            }
        ) {
            Text(UPDATE)
        }
    }
}






