package colombiadex.navigation

import colombiadex.core.Constants.Companion.MASCOTAS_SCREEN
import colombiadex.core.Constants.Companion.UPDATE_MASCOTAS_SCREEN

sealed class Screen(val route: String) {
    object PokemonsScreen : Screen(MASCOTAS_SCREEN)
    object UpdatePokemonScreen : Screen(UPDATE_MASCOTAS_SCREEN)
}
