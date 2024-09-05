package com.example.animationcountdown

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCounter(
    count : Int,
    modifier : Modifier = Modifier,
    style : TextStyle = MaterialTheme.typography.bodyLarge
) {
    var oldCount by remember {
        mutableStateOf(count)
    }
    SideEffect {
        oldCount = count
    }
    Row(
        modifier = modifier
    ) {
        val countString = count.toString()
        val oldcountString = oldCount.toString()
        for (i in countString.indices) {
            val oldChar = oldcountString.getOrNull(i)
            val newChar = countString[i]
            val Char = if (oldChar == newChar){
                oldcountString[i]
            } else {
                countString[i]
            }
            AnimatedContent(
                targetState = Char,
                transitionSpec = {
                    slideInVertically { it } togetherWith slideOutVertically { -it }
                }
            ){ Char ->
                Text(
                    text = Char.toString(),
                    fontSize = 40.sp,
                    style = style,
                    softWrap = false
                )
            }
        }
    }
}