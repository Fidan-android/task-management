package com.example.taskmanagement.splash.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    onNavigateToHome: () -> Unit,
    onNavigateToWelcome: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.isFirstLaunch.collect {
            if (it) {
                onNavigateToWelcome()
            } else {
                onNavigateToHome()
            }
        }
    }
    Scaffold { innerPadding ->
        Text(text = "Splash screen", modifier = Modifier.padding(innerPadding))
    }
}