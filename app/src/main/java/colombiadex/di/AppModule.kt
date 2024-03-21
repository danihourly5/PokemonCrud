package colombiadex.di

import android.content.Context
import androidx.room.Room
import colombiadex.core.Constants.Companion.MASCOTA_TABLE
import colombiadex.data.network.PokemonDB
import colombiadex.data.network.PokemonDao
import colombiadex.data.repository.PokemonRepositoryImpl
import colombiadex.domain.repository.PokemonRepository
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

