package colombiadex.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Update
import colombiadex.core.Constants.Companion.MASCOTA_TABLE
import colombiadex.domain.model.Pokemon
import colombiadex.domain.repository.Pokemons
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {
    @Query("SELECT * FROM $MASCOTA_TABLE ORDER BY id ASC")
    fun getPokemons(): Flow<Pokemons>

    @Insert(onConflict = IGNORE)
    fun addPokemon(mascota: Pokemon)

    // getPokemon
    @Query("SELECT * FROM $MASCOTA_TABLE WHERE id = :id")
    fun getPokemon(id: Int): Pokemon

    // updatePokemon
    @Update
    fun updatePokemon(mascota: Pokemon)

    // deletePokemon
    @Delete
    fun deletePokemon(mascota: Pokemon)

}