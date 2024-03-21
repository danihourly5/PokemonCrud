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
import colombiadex.core.Constants.Companion.ADD_POKEMON
import colombiadex.core.Constants.Companion.ALTURA
import colombiadex.core.Constants.Companion.CATEGORIA
import colombiadex.core.Constants.Companion.DESCRIPCION
import colombiadex.core.Constants.Companion.NOMBRE
import colombiadex.core.Constants.Companion.DISMISS
import colombiadex.core.Constants.Companion.GENERO
import colombiadex.core.Constants.Companion.NO_VALUE
import colombiadex.core.Constants.Companion.PESO
import colombiadex.core.Constants.Companion.SUPERPODER
import colombiadex.domain.model.Pokemon
import kotlinx.coroutines.job

@Composable
fun AddPokemonAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addPokemon: (pokemon: Pokemon) -> Unit
) {
    if (openDialog) {
        var nombre by remember { mutableStateOf(NO_VALUE) }
        var superpoder by remember { mutableStateOf(NO_VALUE) }
        var genero by remember { mutableStateOf(NO_VALUE) }
        var descripcion by remember { mutableStateOf(NO_VALUE) }
        var peso by remember { mutableStateOf(NO_VALUE) }
        var altura by remember { mutableStateOf(NO_VALUE) }
        var categoria by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(ADD_POKEMON)
            },
            text = {
                Column {
                    TextField(
                        value = nombre,
                        onValueChange = { nombre = it },
                        placeholder = {
                            Text(NOMBRE)
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
                        value = superpoder,
                        onValueChange = { superpoder = it },
                        placeholder = {
                            Text(SUPERPODER)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = genero,
                        onValueChange = { genero = it },
                        placeholder = {
                            Text(GENERO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = descripcion,
                        onValueChange = { descripcion = it },
                        placeholder = {
                            Text(DESCRIPCION)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = peso,
                        onValueChange = { peso = it },
                        placeholder = {
                            Text(PESO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = altura,
                        onValueChange = { altura = it },
                        placeholder = {
                            Text(ALTURA)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = categoria,
                        onValueChange = { categoria = it },
                        placeholder = {
                            Text(CATEGORIA)
                        }
                    )

                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val pokemon = Pokemon(0, nombre, superpoder, genero, descripcion, peso, altura, categoria)
                        addPokemon(pokemon)
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