package com.example.taskmanagement.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.ui.theme.TaskManagementTheme
import com.example.core.ui.widget.AppBackground
import com.example.taskmanagement.home.presentation.components.HomeAppBar

@Composable
fun HomeScreen() {
    AppBackground(
        modifier = Modifier
            .statusBarsPadding()
    ) {
        Scaffold(
            topBar = { HomeAppBar() }
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {

            }
        }
    }
}

@Preview(name = "Home preview", showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    TaskManagementTheme {
        HomeScreen()
    }
}