package colombiadex.data.repository

import colombiadex.data.network.PokemonDao
import colombiadex.domain.model.Pokemon
import colombiadex.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val mascotaDao: PokemonDao
) : PokemonRepository {
    override fun getPokemonsFromRoom() = mascotaDao.getPokemons()
    override fun addPokemonToRoom(mascota: Pokemon) = mascotaDao.addPokemon(mascota)

    // getPokemon
    override fun getPokemonFromRoom(id: Int) = mascotaDao.getPokemon(id)

    // updatePokemons
    override fun updatePokemonInRoom(mascota: Pokemon) =
        mascotaDao.updatePokemon(mascota)

    // deletePokemon
    override fun deletePokemonFromRoom(mascota: Pokemon) =
        mascotaDao.deletePokemon(mascota)


}
