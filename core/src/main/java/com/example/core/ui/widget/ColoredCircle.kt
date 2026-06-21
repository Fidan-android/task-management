package com.example.core.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ColoredCircle(color: Color, modifier: Modifier) {
    Canvas(modifier = modifier) {
        drawCircle(color = color, radius = size.width)
    }
}