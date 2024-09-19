package com.example.tic_tac_toe

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            MainScreen { size, player1, player2 ->
                navController.navigate("game_screen/$size/$player1/$player2")
            }
        }
        composable(
            route = "game_screen/{size}/{player1}/{player2}",
            arguments = listOf(
                navArgument("size") { type = NavType.IntType },
                navArgument("player1") { type = NavType.StringType },
                navArgument("player2") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val size = backStackEntry.arguments?.getInt("size") ?: 3
            val player1 = backStackEntry.arguments?.getString("player1") ?: ""
            val player2 = backStackEntry.arguments?.getString("player2") ?: ""
            GameScreen(player1 = player1, player2 = player2, boardSize = size)
        }
    }
}