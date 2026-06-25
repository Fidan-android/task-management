package com.example.taskmanagement.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object MainRoute

fun NavGraphBuilder.mainGraph() {
    composable<MainRoute> {
        MainScreen()
    }
}