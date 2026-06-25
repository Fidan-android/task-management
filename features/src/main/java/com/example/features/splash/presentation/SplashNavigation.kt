package com.example.features.splash.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object SplashRoute

fun NavGraphBuilder.splashGraph(
    onNavigateToMain: () -> Unit,
    onNavigateToWelcome: () -> Unit,
) {
    composable<SplashRoute> {
        SplashScreen(
            onNavigateToMain = onNavigateToMain,
            onNavigateToWelcome = onNavigateToWelcome
        )
    }
}