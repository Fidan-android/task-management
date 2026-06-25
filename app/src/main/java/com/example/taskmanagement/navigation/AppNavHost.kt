package com.example.taskmanagement.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.features.splash.presentation.SplashRoute
import com.example.features.splash.presentation.splashGraph
import com.example.features.welcome.presentation.WelcomeRoute
import com.example.features.welcome.presentation.welcomeGraph
import com.example.taskmanagement.main.MainRoute
import com.example.taskmanagement.main.mainGraph

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = SplashRoute) {
        splashGraph(
            onNavigateToMain = {
                navController.navigate(MainRoute) {
                    popUpTo(SplashRoute) {
                        inclusive = true
                    }
                }
            },
            onNavigateToWelcome = {
                navController.navigate(WelcomeRoute) {
                    popUpTo(SplashRoute) {
                        inclusive = true
                    }
                }
            }
        )
        welcomeGraph(navController)
        mainGraph()
    }
}
