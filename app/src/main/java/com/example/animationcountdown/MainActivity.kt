package com.example.animationcountdown

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animationcountdown.ui.theme.AnimationCountdownTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimationCountdownTheme {
                AnimatedCountdown()
            }
        }
    }
}
@Composable
fun AnimatedCountdown(){

    val transition = rememberInfiniteTransition(label = "animateColor")
    val animateColor by transition.animateColor(
        initialValue = Color(0xFF60DDAD),
        targetValue = Color(0xFF4285F4),
        animationSpec = infiniteRepeatable(animation = tween(1000), repeatMode = RepeatMode.Reverse),
        label = "CountTextColor"
    )

    Column(
        modifier = Modifier.fillMaxSize()
        , verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var count by remember {
            mutableStateOf(0)
        }
        AnimatedCounter(
            count = count
        )
        Button(
            modifier = Modifier.padding(top = 25.dp),
            onClick = { count++ })
        {
            Text(text = "Increase",
                color = animateColor,
                fontStyle = FontStyle.Normal,
                fontSize = 15.sp
            )
        }
    }
}
@Preview
@Composable
fun AnimatedCountDownPreview(){
    AnimationCountdownTheme {
        AnimatedCountdown()
    }
}
