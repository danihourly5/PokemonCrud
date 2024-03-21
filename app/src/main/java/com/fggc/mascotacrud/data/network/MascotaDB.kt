package com.fggc.mascotacrud.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fggc.mascotacrud.domain.model.Pokemon

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
abstract class PokemonDB : RoomDatabase() {
    abstract fun mascotaDao(): PokemonDao
}