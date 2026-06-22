package com.example.core.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.core.ui.theme.Blue
import com.example.core.ui.theme.Blue25
import com.example.core.ui.theme.Green
import com.example.core.ui.theme.Green25
import com.example.core.ui.theme.Orange
import com.example.core.ui.theme.Orange25
import com.example.core.ui.theme.Plum
import com.example.core.ui.theme.Plum25
import com.example.core.ui.theme.Yellow
import com.example.core.ui.theme.Yellow25

object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "Home",
            image = Icons.Filled.Home,
            route = "home"
        ),
        BarItem(
            title = "Contacts",
            image = Icons.Filled.Face,
            route = "contacts"
        ),
        BarItem(
            title = "About",
            image = Icons.Filled.Info,
            route = "about"
        )
    )
}

data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)

@Composable
fun AppBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.(PaddingValues) -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        Scaffold(
            bottomBar = { BottomNavigationBar() }
        ) { innerPadding ->
            content(innerPadding)
        }
        Background()
    }
}

@Composable
private fun BottomNavigationBar() {
    NavigationBar {
        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = navItem.route == "home",
                onClick = {
                    /*navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }*/
                },
                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title
                    )
                },
                label = {
                    Text(text = navItem.title)
                }
            )
        }
    }
}

@Composable
private fun Background() {
    Column(modifier = Modifier.fillMaxSize()) {
        GradientCircle(
            colors = listOf(Green, Green25),
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(modifier = Modifier.padding(start = 40.dp)) {
            GradientCircle(
                colors = listOf(Plum, Plum25),
                modifier = Modifier
                    .size(74.dp)
            )
        }
        GradientCircle(
            colors = listOf(Plum, Plum25),
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.End)
        )
        GradientCircle(
            colors = listOf(Yellow, Yellow25),
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.End)
        )
        Spacer(modifier = Modifier.weight(1f))
        GradientCircle(
            colors = listOf(Blue, Blue25),
            modifier = Modifier
                .size(96.dp)
                .align(Alignment.Start)
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .padding(end = 40.dp)
                .align(Alignment.End)
        ) {
            GradientCircle(
                colors = listOf(Orange, Orange25),
                modifier = Modifier
                    .size(58.dp)
            )
        }
    }
}