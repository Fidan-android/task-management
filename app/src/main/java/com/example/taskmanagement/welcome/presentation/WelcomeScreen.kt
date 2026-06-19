package com.example.taskmanagement.welcome.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.ui.theme.Blue
import com.example.core.ui.theme.Blue15
import com.example.core.ui.theme.Cyan
import com.example.core.ui.theme.Cyan15
import com.example.core.ui.theme.Green
import com.example.core.ui.theme.Green15
import com.example.core.ui.theme.Pink
import com.example.core.ui.theme.TaskManagementTheme
import com.example.core.ui.theme.White
import com.example.core.ui.theme.Yellow
import com.example.core.ui.theme.Yellow15
import com.example.core.ui.widget.CustomButton
import com.example.core.ui.widget.GradientCircle
import com.example.taskmanagement.R

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel = hiltViewModel(),
    onNavigateToHome: () -> Unit,
) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                contentAlignment = Alignment.Center,
            ) {
                FemaleImage()
                YellowGradient(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(end = 80.dp)
                )
                GreenGradient(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(bottom = 60.dp)
                )
                BlueGradient(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 60.dp)
                )
                CyanGradient(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                )
            }
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
                        viewModel.onLetsStart()
                        onNavigateToHome()
                    }
                )
            }
        }

    }
}

@Composable
private fun FemaleImage() {
    Image(
        painterResource(R.drawable.female),
        contentDescription = "Female",
        modifier = Modifier.size(180.dp)
    )
}

@Composable
private fun YellowGradient(modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        GradientCircle(
            colors = listOf(Yellow, Yellow15),
            modifier = Modifier
                .size(80.dp)
        )
        Row {
            Circle(color = Blue, modifier = Modifier.size(4.dp))
            Spacer(modifier = Modifier.size(80.dp))
        }
        Image(
            painterResource(R.drawable.calendar),
            contentDescription = "Notifications",
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
private fun GreenGradient(modifier: Modifier) {
    Row(modifier = modifier) {
        GradientCircle(
            colors = listOf(Green, Green15),
            modifier = Modifier.size(80.dp)
        )
        Column {
            Circle(color = Yellow, modifier = Modifier.size(4.dp))
            Spacer(modifier = Modifier.size(10.dp))
        }
        Image(
            painterResource(R.drawable.chart),
            contentDescription = "Chart",
            modifier = Modifier
                .size(26.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
private fun BlueGradient(modifier: Modifier) {
    Column(modifier = modifier) {
        Image(
            painterResource(R.drawable.vase),
            contentDescription = "Vase",
            modifier = Modifier
                .size(60.dp)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(modifier = Modifier.size(width = 60.dp, height = 120.dp))
            Circle(color = Pink, modifier = Modifier.size(4.dp))
        }
        GradientCircle(
            colors = listOf(Blue, Blue15),
            modifier = Modifier.size(60.dp)
        )
    }
}

@Composable
private fun CyanGradient(modifier: Modifier) {
    Row(modifier = modifier) {
        Image(
            painterResource(R.drawable.notifications),
            contentDescription = "Notifications",
            modifier = Modifier.size(70.dp)
        )
        Column {
            Spacer(modifier = Modifier.size(width = 20.dp, height = 120.dp))
            Circle(color = Green, modifier = Modifier.size(4.dp))
        }
        GradientCircle(
            colors = listOf(Cyan, Cyan15),
            modifier = Modifier.size(70.dp)
        )
    }
}

@Composable
private fun Circle(color: Color, modifier: Modifier) {
    Canvas(modifier = modifier) {
        drawCircle(color = color, radius = size.width)
    }
}

@Preview(showBackground = true, name = "welcome page")
@Composable
fun WelcomePagePreview() {
    TaskManagementTheme {
        WelcomeScreen(onNavigateToHome = {})
    }
}
