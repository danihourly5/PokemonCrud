package colombiadex.domain.repository

import colombiadex.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

typealias Pokemons = List<Pokemon>

interface PokemonRepository {
    fun getPokemonsFromRoom(): Flow<Pokemons>
    fun addPokemonToRoom(pokemon: Pokemon)

    // getPokemonFromRoom
    fun getPokemonFromRoom(id: Int): Pokemon

    //updatePokemonInRoom
    fun updatePokemonInRoom(pokemon: Pokemon)

    //deletePokemonFromRoom
    fun deletePokemonFromRoom(pokemon: Pokemon)


}