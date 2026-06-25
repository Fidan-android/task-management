package com.example.taskmanagement.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.features.home.presentation.HomeRoute
import com.example.features.home.presentation.homeGraph
import com.example.features.profile.presentation.profileGraph
import com.example.features.project.presentation.projectGraph
import com.example.features.task.presentation.taskGraph

@Composable
fun MainNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeRoute,
    ) {
        homeGraph()
        taskGraph()
        projectGraph()
        profileGraph()
    }
}