package com.example.animationcountdown
//
//c@Composable
//fun AnimatedCounter(
//    count: Int,
//    modifier: Modifier = Modifier,
//    style: TextStyle = MaterialTheme.typography.body1
//) {
//    var oldCount by remember {
//        mutableStateOf(count)
//    }
//    SideEffect {
//        oldCount = count
//    }
//    Row(modifier = modifier) {
//        val countString = count.toString()
//        val oldCountString = oldCount.toString()
//        for(i in countString.indices) {
//            val oldChar = oldCountString.getOrNull(i)
//            val newChar = countString[i]
//            val char = if(oldChar == newChar) {
//                oldCountString[i]
//            } else {
//                countString[i]
//            }
//            AnimatedContent(
//                targetState = char,
//                transitionSpec = {
//                    slideInVertically { it } with slideOutVertically { -it }
//                }
//            ) { char ->
//                Text(
//                    text = char.toString(),
//                    style = style,
//                    softWrap = false
//                )
//            }
//        }
//    }
//}
//Column(
//modifier = Modifier.fillMaxSize(),
//verticalArrangement = Arrangement.Center,
//horizontalAlignment = Alignment.CenterHorizontally
//) {
//    var count by remember {
//        mutableStateOf(0)
//    }
//    AnimatedCounter(
//        count = count,
//        style = MaterialTheme.typography.h1
//    )
//    Button(onClick = { count++ }) {
//        Text(text = "Increment")
//    }
//}