package colombiadex.presentation.mascotas.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import colombiadex.core.Constants.Companion.ADD
import colombiadex.core.Constants.Companion.ADD_MASCOTA
import colombiadex.core.Constants.Companion.ANIMAL
import colombiadex.core.Constants.Companion.DISMISS
import colombiadex.core.Constants.Companion.NO_VALUE
import colombiadex.core.Constants.Companion.RAZA
import colombiadex.domain.model.Pokemon
import kotlinx.coroutines.job

@Composable
fun AddPokemonAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPokemon: (mascota: Pokemon) -> Unit
) {
    if (openDialog) {
        var animal by remember { mutableStateOf(NO_VALUE) }
        var raza by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_MASCOTA)
            },
            text = {
                Column {
                    TextField(
                        value = animal,
                        onValueChange = { animal = it },
                        placeholder = {
                            Text(ANIMAL)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = raza,
                        onValueChange = { raza = it },
                        placeholder = {
                            Text(RAZA)
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val mascota = Pokemon(0, animal, raza)
                        addPokemon(mascota)
                    }) {
                    Text(ADD)
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(DISMISS)
                }
            }

        )
    }
}