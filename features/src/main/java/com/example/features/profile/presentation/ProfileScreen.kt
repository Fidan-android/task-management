package com.example.features.profile.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProfileScreen() {
    Scaffold { innerPadding ->
        Text(text = "Profile screen", modifier = Modifier.padding(innerPadding))
    }
}