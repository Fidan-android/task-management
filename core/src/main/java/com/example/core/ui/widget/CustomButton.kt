package com.example.core.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import com.example.core.ui.theme.Purple
import com.example.core.ui.theme.White
import kotlin.math.sin

@Composable
fun CustomButton(
    text: String,
    style: TextStyle,
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    val h = 120f
    val amp = 7f
    val iconWidth = 42f
    val iconHeight = 32f
    val cornerRadius = 30f

    val textMeasurer = rememberTextMeasurer()
    val textLayout = textMeasurer.measure(
        text = AnnotatedString(text),
        style = style
    )

    Canvas(modifier = modifier
        .fillMaxWidth()
        .clickable(onClick = onClick)) {
        val width = size.width

        val mainPath = Path().apply { moveTo(cornerRadius, 0f) }

        // верхняя синусоида
        for (x in cornerRadius.toInt()..(width - cornerRadius).toInt()) {
            val y: Float = -amp * sin(Math.PI * x / width).toFloat()
            mainPath.lineTo(x.toFloat(), y)
        }

        // правый верхний угол
        mainPath.arcTo(
            rect = Rect(
                left = width - cornerRadius * 2,
                top = 0f,
                right = width,
                bottom = cornerRadius * 2
            ),
            startAngleDegrees = -90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        // правая сторона
        mainPath.lineTo(width, h - cornerRadius)

        // правый нижний угол
        mainPath.arcTo(
            rect = Rect(
                left = width - cornerRadius * 2,
                top = h - cornerRadius * 2,
                right = width,
                bottom = h
            ),
            startAngleDegrees = 0f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        // нижняя синусоида
        for (x in (width - cornerRadius).toInt() downTo cornerRadius.toInt()) {
            val y: Float = h + amp * sin(Math.PI * x / width).toFloat()
            mainPath.lineTo(x.toFloat(), y)
        }

        // левый нижний угол
        mainPath.arcTo(
            rect = Rect(
                left = 0f,
                top = h - cornerRadius * 2,
                right = cornerRadius * 2,
                bottom = h
            ),
            startAngleDegrees = 90f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        // левая сторона
        mainPath.lineTo(0f, cornerRadius)

        // леваый верхний угол
        mainPath.arcTo(
            rect = Rect(
                left = 0f,
                top = 0f,
                right = cornerRadius * 2,
                bottom = cornerRadius * 2
            ),
            startAngleDegrees = 180f,
            sweepAngleDegrees = 90f,
            forceMoveTo = false
        )

        mainPath.close()
        drawPath(
            mainPath,
            color = Purple,
            style = Fill
        )
        drawText(
            textLayout,
            topLeft = Offset(
                (size.width - textLayout.size.width) / 2f,
                (h - textLayout.size.height) / 2f
            )
        )
        translate(top = (h - iconHeight) / 2, left = size.width - iconWidth - 72f) {
            with(icon) {
                draw(
                    size = Size(iconWidth, iconHeight),
                    colorFilter = ColorFilter.tint(color = White)
                )
            }
        }
    }
}