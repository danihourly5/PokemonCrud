package com.fggc.mascotacrud.di

import android.content.Context
import androidx.room.Room
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTA_TABLE
import com.fggc.mascotacrud.data.network.PokemonDB
import com.fggc.mascotacrud.data.network.PokemonDao
import com.fggc.mascotacrud.data.repository.PokemonRepositoryImpl
import com.fggc.mascotacrud.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providePokemonDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        PokemonDB::class.java,
        MASCOTA_TABLE
    ).build()

    @Provides
    fun providePokemonDao(
        mascotaDB: PokemonDB
    ) = mascotaDB.mascotaDao()

    @Provides
    fun providePokemonRepository(
        mascotaDao: PokemonDao
    ): PokemonRepository = PokemonRepositoryImpl(
        mascotaDao = mascotaDao
    )

}

