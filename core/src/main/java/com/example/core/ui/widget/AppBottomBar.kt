package com.example.core.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.ui.model.BottomTabRoute
import com.example.core.ui.theme.Lavender
import com.example.core.ui.theme.Purple
import com.example.core.ui.theme.White

@Composable
fun AppBottomBar(
    selectedTab: BottomTabRoute,
    onTap: (BottomTabRoute) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Lavender)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(start = 32.dp, top = 16.dp, end = 32.dp)
        ) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BottomItem(
                    description = "home",
                    icon = R.drawable.home_unselected,
                    selectedIcon = R.drawable.home_selected,
                    isSelected = selectedTab == BottomTabRoute.HOME,
                    modifier = Modifier.clickable(onClick = { onTap(BottomTabRoute.HOME) }),
                )
                BottomItem(
                    description = "task",
                    icon = R.drawable.calendar_unselected,
                    selectedIcon = R.drawable.calendar_selected,
                    isSelected = selectedTab == BottomTabRoute.TASK,
                    modifier = Modifier.clickable(onClick = { onTap(BottomTabRoute.TASK) }),
                )
            }
            Spacer(modifier = Modifier.width(130.dp))
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                BottomItem(
                    description = "project",
                    icon = R.drawable.document_unselected,
                    selectedIcon = R.drawable.document_selected,
                    isSelected = selectedTab == BottomTabRoute.PROJECT,
                    modifier = Modifier.clickable(onClick = { onTap(BottomTabRoute.PROJECT) }),
                )
                BottomItem(
                    description = "profile",
                    icon = R.drawable.profile_unselected,
                    selectedIcon = R.drawable.profile_selected,
                    isSelected = selectedTab == BottomTabRoute.PROFILE,
                    modifier = Modifier.clickable(onClick = { onTap(BottomTabRoute.PROFILE) }),
                )
            }
        }
        FloatingActionButton(
            onClick = {},
            shape = CircleShape,
            contentColor = White,
            containerColor = Purple,
            modifier = Modifier
                .offset(y = (-24).dp)
                .align(Alignment.TopCenter)
        ) {
            Icon(Icons.Default.Add, null)
        }
    }
}

@Composable
private fun BottomItem(
    icon: Int,
    selectedIcon: Int,
    description: String,
    isSelected: Boolean,
    modifier: Modifier,
) {
    Image(
        painter = painterResource(if (isSelected) selectedIcon else icon),
        contentDescription = description,
        modifier = modifier.size(24.dp)
    )
}