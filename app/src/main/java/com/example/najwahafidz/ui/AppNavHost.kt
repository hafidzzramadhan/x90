package com.example.najwahafidz.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {

        composable("splash") {
            SplashScreen(navController)
        }

        composable("landing") {
            LandingScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("dashboard"){
            DashboardScreen(navController)
        }
    }
}
