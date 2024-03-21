package com.fggc.mascotacrud.presentation.mascotas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fggc.mascotacrud.core.Constants.Companion.NO_VALUE
import com.fggc.mascotacrud.domain.model.Pokemon
import com.fggc.mascotacrud.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonsViewModel @Inject constructor(
    private val repo: PokemonRepository
) : ViewModel() {

    var mascota by mutableStateOf(Pokemon(0, NO_VALUE, NO_VALUE))
    var openDialog by mutableStateOf(false)
    val mascotas = repo.getPokemonsFromRoom()
    fun addPokemon(mascota: Pokemon) = viewModelScope.launch(Dispatchers.IO)
    {
        repo.addPokemonToRoom(mascota)
    }

    fun closeDialog() {
        openDialog = false
    }

    fun openDialog() {
        openDialog = true
    }

    fun deletePokemon(mascota: Pokemon) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.deletePokemonFromRoom(mascota)
        }

    fun updateAnimal(animal: String) {
        mascota = mascota.copy(
            animal = animal
        )
    }

    fun updateRaza(raza: String) {
        mascota = mascota.copy(
            raza = raza
        )
    }

    fun updatePokemon(mascota: Pokemon) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.updatePokemonInRoom(mascota)
        }

    fun getPokemon(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ) {
        mascota = repo.getPokemonFromRoom(id)
    }
}