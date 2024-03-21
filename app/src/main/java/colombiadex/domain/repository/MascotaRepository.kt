package colombiadex.domain.repository

import colombiadex.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

typealias Pokemons = List<Pokemon>

interface PokemonRepository {
    fun getPokemonsFromRoom(): Flow<Pokemons>
    fun addPokemonToRoom(mascota: Pokemon)

    // getPokemonFromRoom
    fun getPokemonFromRoom(id: Int): Pokemon

    //updatePokemonInRoom
    fun updatePokemonInRoom(mascota: Pokemon)

    //deletePokemonFromRoom
    fun deletePokemonFromRoom(mascota: Pokemon)


}