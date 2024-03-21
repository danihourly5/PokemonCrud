package colombiadex.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import colombiadex.core.Constants.Companion.POKEMON_TABLE

@Entity(tableName = POKEMON_TABLE)
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val superpoder: String,
    val genero : String,
    val descripcion: String,
    val peso: String,
    val altura: String,
    val categoria: String
)
