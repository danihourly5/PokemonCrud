package colombiadex.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import colombiadex.core.Constants.Companion.MASCOTA_TABLE

@Entity(tableName = MASCOTA_TABLE)
data class Pokemon(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val animal: String,
    val raza: String
)
