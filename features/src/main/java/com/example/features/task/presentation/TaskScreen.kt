package com.example.features.task.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TaskScreen() {
    Scaffold { innerPadding ->
        Text(text = "Task screen", modifier = Modifier.padding(innerPadding))
    }
}