package com.example.taskmanagement

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.taskmanagement.home.presentation.homeGraph
import com.example.taskmanagement.splash.presentation.SplashRoute
import com.example.taskmanagement.splash.presentation.splashGraph
import com.example.taskmanagement.welcome.presentation.welcomeGraph

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = SplashRoute) {
        splashGraph(navController)
        homeGraph()
        welcomeGraph()
    }
}
