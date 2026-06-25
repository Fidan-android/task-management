package com.example.features.home.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

fun NavGraphBuilder.homeGraph() {
    composable<HomeRoute> {
        HomeScreen()
    }
}