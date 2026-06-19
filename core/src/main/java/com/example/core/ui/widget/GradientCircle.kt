package com.example.core.ui.widget

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb

@Composable
fun GradientCircle(colors: List<Color>, modifier: Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        drawIntoCanvas { canvas ->
            val paint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                shader = android.graphics.RadialGradient(
                    center.x,
                    center.y,
                    1f,
                    colors.map { it.toArgb() }.toIntArray(),
                    floatArrayOf(0f, 100f),
                    android.graphics.Shader.TileMode.CLAMP
                )
                maskFilter = BlurMaskFilter(size.width, BlurMaskFilter.Blur.NORMAL)
            }

            canvas.nativeCanvas.drawCircle(
                center.x,
                center.y,
                size.width,
                paint
            )
        }
    }
}