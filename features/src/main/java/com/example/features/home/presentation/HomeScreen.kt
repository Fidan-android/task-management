package com.example.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.ui.theme.Lavender
import com.example.core.ui.theme.Purple
import com.example.core.ui.theme.White
import com.example.core.ui.widget.ColoredCircle
import com.example.core.ui.widget.CustomButton
import com.example.core.ui.widget.CustomButtonStyle
import com.example.core.ui.widget.CustomDonutChart
import com.example.core.ui.widget.CustomDonutChartStyle
import com.example.features.R
import kotlin.random.Random

@Composable
fun HomeScreen() {
    Column {
        Header(
            Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, start = 22.dp, end = 22.dp)
                .height(IntrinsicSize.Min),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Statistics(
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .fillMaxWidth()
                .height(IntrinsicSize.Min),
        )
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun Header(modifier: Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(R.drawable.avatar),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.size(16.dp))
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Hello!",
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = "Livia Vaccaro",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontSize = 19.sp,
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box {
            ColoredCircle(
                color = Purple,
                modifier = Modifier
                    .size(6.dp)
                    .align(Alignment.TopEnd)
            )
            Image(
                painter = painterResource(R.drawable.notification),
                contentDescription = "notifications",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
private fun Statistics(modifier: Modifier) {
    val colors = CardColors(
        containerColor = Purple,
        contentColor = White,
        disabledContainerColor = Color.Gray,
        disabledContentColor = Color.Gray,
    )
    val buttonStyle = CustomButtonStyle(
        height = 40.dp,
        text = "View Task",
        cornerRadius = 9.dp,
        background = Lavender,
        textStyle = MaterialTheme.typography.titleLarge.copy(
            fontSize = 14.sp,
            color = Purple
        ),
    )

    Card(
        colors = colors,
        modifier = modifier,
        shape = RoundedCornerShape(corner = CornerSize(24.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight()
                    .padding(6.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Your today's task almost done!",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.height(28.dp))
                CustomButton(
                    buttonStyle = buttonStyle,
                    modifier = Modifier
                        .clickable(onClick = {}),
                )
            }
            Column(
                modifier = Modifier
                    .weight(2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val donutStyle = CustomDonutChartStyle(
                    percent = 85,
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
                        .size(width = 80.dp, height = 80.dp)
                )
            }
            Image(
                painter = painterResource(R.drawable.more),
                contentDescription = "more",
                modifier = Modifier.align(Alignment.Top)
            )
        }
    }
}
