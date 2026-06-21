package com.example.core.ui.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import com.example.core.ui.theme.White
import kotlin.math.sin

data class CustomButtonStyle(
    val height: Dp,
    val text: String,
    val cornerRadius: Dp,
    val icon: Painter? = null,
    val iconSize: Size? = null,
    val background: Color = White,
    val textStyle: TextStyle = TextStyle(),
)

@Composable
fun CustomButton(
    modifier: Modifier,
    buttonStyle: CustomButtonStyle,
) {
    val amp = 7f
    with(buttonStyle) {
        val canvasModifier = modifier
            .fillMaxWidth()
            .height(height)
        val textMeasurer = rememberTextMeasurer()
        val textLayout = textMeasurer.measure(
            text = text,
            style = textStyle
        )
        Canvas(modifier = canvasModifier) {
            val buttonWidth = size.width
            val buttonHeight = height.toPx()
            val buttonRadius = cornerRadius.toPx()

            val mainPath = Path().apply { moveTo(buttonRadius, 0f) }

            // верхняя синусоида
            for (x in buttonRadius.toInt()..(buttonWidth - buttonRadius).toInt()) {
                val y: Float = -amp * sin(Math.PI * x / buttonWidth).toFloat()
                mainPath.lineTo(x.toFloat(), y)
            }

            // правый верхний угол
            mainPath.arcTo(
                rect = Rect(
                    left = buttonWidth - buttonRadius * 2,
                    top = 0f,
                    right = buttonWidth,
                    bottom = buttonRadius * 2
                ),
                startAngleDegrees = -90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            // правая сторона
            mainPath.lineTo(buttonWidth, buttonHeight - buttonRadius)

            // правый нижний угол
            mainPath.arcTo(
                rect = Rect(
                    left = buttonWidth - buttonRadius * 2,
                    top = buttonHeight - buttonRadius * 2,
                    right = buttonWidth,
                    bottom = buttonHeight
                ),
                startAngleDegrees = 0f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            // нижняя синусоида
            for (x in (buttonWidth - buttonRadius).toInt() downTo buttonRadius.toInt()) {
                val y: Float = buttonHeight + amp * sin(Math.PI * x / buttonWidth).toFloat()
                mainPath.lineTo(x.toFloat(), y)
            }

            // левый нижний угол
            mainPath.arcTo(
                rect = Rect(
                    left = 0f,
                    top = buttonHeight - buttonRadius * 2,
                    right = buttonRadius * 2,
                    bottom = buttonHeight
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            // левая сторона
            mainPath.lineTo(0f, buttonRadius)

            // леваый верхний угол
            mainPath.arcTo(
                rect = Rect(
                    left = 0f,
                    top = 0f,
                    right = buttonRadius * 2,
                    bottom = buttonRadius * 2
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            mainPath.close()
            drawPath(
                mainPath,
                color = background,
                style = Fill
            )
            drawText(
                textLayout,
                topLeft = Offset(
                    (size.width - textLayout.size.width) / 2f,
                    (buttonHeight - textLayout.size.height) / 2f
                )
            )
            if (icon != null && iconSize != null) {
                translate(
                    top = (buttonHeight - iconSize.height) / 2,
                    left = size.width - iconSize.width - 72f
                ) {
                    with(icon) {
                        draw(
                            size = Size(iconSize.width, iconSize.height),
                            colorFilter = ColorFilter.tint(color = White)
                        )
                    }
                }
            }
        }
    }
}