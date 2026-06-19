package com.example.taskmanagement.welcome.presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.taskmanagement.home.presentation.HomeRoute
import com.example.taskmanagement.splash.presentation.SplashRoute
import kotlinx.serialization.Serializable

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