package com.example.taskmanagement.splash.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.taskmanagement.home.presentation.HomeRoute
import com.example.taskmanagement.welcome.presentation.WelcomeRoute
import kotlinx.serialization.Serializable

@Serializable
data object SplashRoute

fun NavGraphBuilder.splashGraph(
    navController: NavController
) {
    composable<SplashRoute> {
        SplashScreen(
            onNavigateToHome = {
                navController.navigate(HomeRoute) {
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
    }
}