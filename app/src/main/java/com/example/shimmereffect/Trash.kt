package com.example.shimmereffect

//@Composable
//fun ShimmerListItem(
//    isLoading: Boolean,
//    contentAfterLoading: @Composable () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    if(isLoading) {
//        Row(modifier = modifier) {
//            Box(
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(CircleShape)
//                    .shimmerEffect()
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(20.dp)
//                        .shimmerEffect()
//                )
//                Spacer(modifier = Modifier.height(16.dp))
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth(0.7f)
//                        .height(20.dp)
//                        .shimmerEffect()
//                )
//            }
//        }
//    } else {
//        contentAfterLoading()
//    }
//}
//
//fun Modifier.shimmerEffect(): Modifier = composed {
//    var size by remember {
//        mutableStateOf(IntSize.Zero)
//    }
//    val transition = rememberInfiniteTransition()
//    val startOffsetX by transition.animateFloat(
//        initialValue = -2 * size.width.toFloat(),
//        targetValue = 2 * size.width.toFloat(),
//        animationSpec = infiniteRepeatable(
//            animation = tween(1000)
//        )
//    )
//
//    background(
//        brush = Brush.linearGradient(
//            colors = listOf(
//                Color(0xFFB8B5B5),
//                Color(0xFF8F8B8B),
//                Color(0xFFB8B5B5),
//            ),
//            start = Offset(startOffsetX, 0f),
//            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
//        )
//    )
//        .onGloballyPositioned {
//            size = it.size
//        }
//}
//var isLoading by remember {
//    mutableStateOf(true)
//}
//LaunchedEffect(key1 = true) {
//    delay(10000)
//    isLoading = false
//}
//LazyColumn(
//modifier = Modifier.fillMaxSize()
//) {
//    items(20) {
//        ShimmerListItem(
//            isLoading = isLoading,
//            contentAfterLoading = {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Home,
//                        contentDescription = null,
//                        modifier = Modifier.size(100.dp)
//                    )
//                    Spacer(modifier = Modifier.width(16.dp))
//                    Text(
//                        text = "This is a long text to show that our shimmer display " +
//                                "is looking perfectly fine"
//                    )
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        )
//    }
//}