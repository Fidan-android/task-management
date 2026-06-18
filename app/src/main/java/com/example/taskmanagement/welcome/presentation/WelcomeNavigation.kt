package com.example.taskmanagement.welcome.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.taskmanagement.home.presentation.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
data object WelcomeRoute

fun NavGraphBuilder.welcomeGraph() {
    composable<WelcomeRoute> {
        WelcomeScreen()
    }
}