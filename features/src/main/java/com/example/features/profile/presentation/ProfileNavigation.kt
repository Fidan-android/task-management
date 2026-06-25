package com.example.features.profile.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object ProfileRoute

fun NavGraphBuilder.profileGraph() {
    composable<ProfileRoute> {
        ProfileScreen()
    }
}