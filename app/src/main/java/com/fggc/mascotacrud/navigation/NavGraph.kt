package com.fggc.mascotacrud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.fggc.mascotacrud.core.Constants.Companion.MASCOTA_ID
import com.fggc.mascotacrud.navigation.Screen.PokemonsScreen
import com.fggc.mascotacrud.navigation.Screen.UpdatePokemonScreen
import com.fggc.mascotacrud.presentation.mascotas.PokemonsScreen
import com.fggc.mascotacrud.presentation.update_mascotas.UpdatePokemonScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = PokemonsScreen.route
    ) {
        composable(
            route = PokemonsScreen.route
        ) {
            PokemonsScreen(
                navigateToUpdatePokemonScreen = { mascotaId ->
                    navController.navigate(
                        "${UpdatePokemonScreen.route}/${mascotaId}"
                    )
                }
            )
        }
        composable(
            route = "${UpdatePokemonScreen.route}/{$MASCOTA_ID}",
            arguments = listOf(
                navArgument(MASCOTA_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val mascotaId = backStackEntry.arguments?.getInt(MASCOTA_ID) ?: 0
            UpdatePokemonScreen(
                mascotaId = mascotaId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}