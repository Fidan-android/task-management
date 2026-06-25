package com.example.features.task.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object TaskRoute

fun NavGraphBuilder.taskGraph() {
    composable<TaskRoute> {
        TaskScreen()
    }
}