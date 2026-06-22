package com.example.core.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ui.theme.Lavender
import com.example.core.ui.theme.Purple
import com.example.core.ui.theme.TaskManagementTheme
import com.example.core.ui.theme.White

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

@Preview(name = "Custom donut chart")
@Composable
fun CustomDonutChartPreview() {
    TaskManagementTheme {
        Scaffold(containerColor = Purple) { innerPadding ->
            val donutStyle = CustomDonutChartStyle(
                percent = 52,
                color = Lavender,
                strokeWidth = 30f,
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = White
                ),
            )
            CustomDonutChart(
                donutStyle = donutStyle,
                modifier = Modifier
                    .padding(innerPadding)
                    .size(width = 80.dp, height = 80.dp)
            )
        }
    }
}