package com.example.features.welcome.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.ui.theme.Blue
import com.example.core.ui.theme.Blue25
import com.example.core.ui.theme.Cyan
import com.example.core.ui.theme.Cyan25
import com.example.core.ui.theme.Green
import com.example.core.ui.theme.Green25
import com.example.core.ui.theme.Pink
import com.example.core.ui.theme.Purple
import com.example.core.ui.theme.TaskManagementTheme
import com.example.core.ui.theme.White
import com.example.core.ui.theme.Yellow
import com.example.core.ui.theme.Yellow25
import com.example.core.ui.widget.ColoredCircle
import com.example.core.ui.widget.CustomButton
import com.example.core.ui.widget.CustomButtonStyle
import com.example.core.ui.widget.GradientCircle
import com.example.features.R

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

            val buttonStyle = CustomButtonStyle(
                height = 60.dp,
                cornerRadius = 14.dp,
                background = Purple,
                text = "Let's Start",
                iconSize = Size(width = 42f, height = 32f),
                icon = painterResource(R.drawable.arrow_right),
                textStyle = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 19.sp,
                    color = White
                ),
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
                    buttonStyle = buttonStyle,
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .clickable(onClick = {
                            viewModel.onLetsStart()
                            onNavigateToHome()
                        }),
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
            colors = listOf(Yellow, Yellow25),
            modifier = Modifier
                .size(80.dp)
        )
        Row {
            ColoredCircle(color = Blue, modifier = Modifier.size(4.dp))
            Spacer(modifier = Modifier.size(80.dp))
        }
    }
}

@Composable
private fun GreenGradient(modifier: Modifier) {
    Row(modifier = modifier) {
        GradientCircle(
            colors = listOf(Green, Green25),
            modifier = Modifier.size(80.dp)
        )
        Column {
            ColoredCircle(color = Yellow, modifier = Modifier.size(4.dp))
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
            ColoredCircle(color = Pink, modifier = Modifier.size(4.dp))
        }
        GradientCircle(
            colors = listOf(Blue, Blue25),
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
            ColoredCircle(color = Green, modifier = Modifier.size(4.dp))
        }
        GradientCircle(
            colors = listOf(Cyan, Cyan25),
            modifier = Modifier.size(70.dp)
        )
    }
}

@Preview(showBackground = true, name = "welcome page")
@Composable
fun WelcomePagePreview() {
    TaskManagementTheme {
        WelcomeScreen(onNavigateToHome = {})
    }
}
