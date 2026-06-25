package com.example.features.welcome.presentation

import androidx.navigation.NavController
import kotlinx.serialization.Serializable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.features.home.presentation.HomeRoute
import com.example.features.splash.presentation.SplashRoute

@Serializable
data object WelcomeRoute

fun NavGraphBuilder.welcomeGraph(navController: NavController) {
    composable<WelcomeRoute> {
        WelcomeScreen(
            onNavigateToHome = {
                navController.navigate(HomeRoute) {
                    popUpTo(SplashRoute) {
                        inclusive = true
                    }
                }
            })
    }
}