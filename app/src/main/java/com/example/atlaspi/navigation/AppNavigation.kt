package com.example.atlaspi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.atlaspi.screens.LoginScreen
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            LoginScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

    }
}

