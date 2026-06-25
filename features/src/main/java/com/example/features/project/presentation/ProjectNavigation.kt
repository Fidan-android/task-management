package com.example.features.project.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProjectRoute

fun NavGraphBuilder.projectGraph() {
    composable<ProjectRoute> {
        ProjectScreen()
    }
}