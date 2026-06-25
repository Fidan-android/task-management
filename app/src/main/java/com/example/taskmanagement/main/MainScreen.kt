package com.example.taskmanagement.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core.ui.model.BottomTabRoute
import com.example.core.ui.theme.Transparent
import com.example.core.ui.widget.AppBackground
import com.example.core.ui.widget.AppBottomBar
import com.example.features.home.presentation.HomeRoute
import com.example.features.profile.presentation.ProfileRoute
import com.example.features.project.presentation.ProjectRoute
import com.example.features.task.presentation.TaskRoute
import com.example.taskmanagement.navigation.MainNavHost

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentDestination = navController
        .currentBackStackEntryAsState()
        .value
        ?.destination
    val selectedTab = when {
        currentDestination?.hasRoute<HomeRoute>() == true ->
            BottomTabRoute.HOME

        currentDestination?.hasRoute<TaskRoute>() == true ->
            BottomTabRoute.TASK

        currentDestination?.hasRoute<ProjectRoute>() == true ->
            BottomTabRoute.PROJECT

        currentDestination?.hasRoute<ProfileRoute>() == true ->
            BottomTabRoute.PROFILE

        else -> BottomTabRoute.HOME
    }

    AppBackground {
        Scaffold(
            containerColor = Transparent,
            bottomBar = {
                AppBottomBar(
                    selectedTab = selectedTab,
                    onTap = { route ->
                        if (selectedTab == route) return@AppBottomBar
                        when (route) {
                            BottomTabRoute.HOME -> navigate(navController, HomeRoute)
                            BottomTabRoute.TASK -> navigate(navController, TaskRoute)
                            BottomTabRoute.PROJECT -> navigate(navController, ProjectRoute)
                            BottomTabRoute.PROFILE -> navigate(navController, ProfileRoute)
                        }
                    }
                )
            }
        ) { innerPadding ->
            MainNavHost(
                navController = navController, modifier = Modifier
                    .padding(innerPadding)
            )
        }
    }
}

private fun navigate(controller: NavHostController, route: Any) {
    controller.navigate(route) {
        popUpTo(controller.graph.startDestinationId) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}