package com.example.core.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import com.example.core.ui.theme.Lavender

data class CustomDonutChartStyle(
    val color: Color,
    val percent: Int,
    val strokeWidth: Float,
    val textStyle: TextStyle,
)

@Composable
fun CustomDonutChart(modifier: Modifier, donutStyle: CustomDonutChartStyle) {
    with(donutStyle) {
        val textMeasurer = rememberTextMeasurer()
        val textLayout = textMeasurer.measure(
            text = "$percent%",
            style = textStyle
        )
        Canvas(modifier = modifier) {
            drawArc(
                color = Lavender,
                startAngle = 0f,
                sweepAngle = 360f * percent / 100f,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round),
                size = Size(size.minDimension, size.minDimension),
            )
            drawCircle(
                color = Lavender.copy(alpha = 0.12f),
                style = Stroke(width = strokeWidth),
            )
            drawText(
                textLayoutResult = textLayout,
                topLeft = Offset(
                    (size.width - textLayout.size.width) / 2f,
                    (size.height - textLayout.size.height) / 2f
                )
            )
        }
    }
}