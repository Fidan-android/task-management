package com.example.core.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun AppBackground(
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = modifier.fillMaxSize()) {
        content()
        Background()
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