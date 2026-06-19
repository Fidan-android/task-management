package com.example.taskmanagement.home.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.ui.theme.TaskManagementTheme
import com.example.core.ui.widget.AppScaffold

@Composable
fun HomeScreen() {
    AppScaffold {}
}

@Preview(name = "Home preview", showBackground = true, showSystemUi = true)
@Composable
fun HomePreview() {
    TaskManagementTheme {
        HomeScreen()
    }
}