package com.example.taskmanagement.welcome.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ui.theme.TaskManagementTheme
import com.example.core.ui.theme.White
import com.example.core.ui.widget.CustomButton
import com.example.taskmanagement.R

@Composable
fun WelcomeScreen() {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            )
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Task Management &\nTo-Do List",
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 20.dp)
                )
                Text(
                    text = "This productive tool is designed " +
                            "to help you better manage your task " +
                            "project-wise conveniently!",
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 40.dp, start = 50.dp, end = 50.dp)
                )
                CustomButton(
                    modifier = Modifier.padding(start = 30.dp, end = 30.dp),
                    text = "Let's Start",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 19.sp,
                        color = White
                    ),
                    icon = painterResource(R.drawable.arrow_right),
                    onClick = {

                    }
                )
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
