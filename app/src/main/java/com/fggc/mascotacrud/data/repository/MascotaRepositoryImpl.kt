package com.fggc.mascotacrud.data.repository

import com.fggc.mascotacrud.data.network.PokemonDao
import com.fggc.mascotacrud.domain.model.Pokemon
import com.fggc.mascotacrud.domain.repository.PokemonRepository

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
