package colombiadex.presentation.mascotas.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import colombiadex.core.Constants.Companion.DELETE_MASCOTA

@Composable
fun DeleteIcon(
    deletePokemon: () -> Unit
) {
    IconButton(onClick = deletePokemon) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_MASCOTA
        )
    }
}