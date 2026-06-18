package com.example.taskmanagement.welcome.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskmanagement.ui.theme.Purple40
import com.example.taskmanagement.ui.theme.PurpleGrey40
import com.example.taskmanagement.ui.theme.TaskManagementTheme
import com.example.taskmanagement.ui.theme.White

@Composable
fun WelcomeScreen() {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = "Task Management & To-Do List", modifier = Modifier.padding(bottom = 20.dp))
            Text(
                text = "This productive tool is designed " +
                        "to help you better manage your task " +
                        "project-wise conveniently!",
                modifier = Modifier.padding(bottom = 40.dp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp),
                colors = ButtonColors(Purple40, White, PurpleGrey40, White),
                onClick = {},
            ) {
                Row {
                    Text(text = "Let’s Start")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "welcome page")
@Composable
fun WelcomePagePreview() {
    TaskManagementTheme {
        WelcomeScreen()
    }
}