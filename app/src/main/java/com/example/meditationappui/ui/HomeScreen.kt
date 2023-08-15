package com.example.meditationappui.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.meditationappui.R
import com.example.meditationappui.curveFromTo
import com.example.meditationappui.data.Feature
import com.example.meditationappui.data.Item
import com.example.meditationappui.ui.theme.CalmBlue
import com.example.meditationappui.ui.theme.DarkBlue
import com.example.meditationappui.ui.theme.HighGreen
import com.example.meditationappui.ui.theme.HighOrange
import com.example.meditationappui.ui.theme.HighPurple
import com.example.meditationappui.ui.theme.HighYellow
import com.example.meditationappui.ui.theme.LowGreen
import com.example.meditationappui.ui.theme.LowOrange
import com.example.meditationappui.ui.theme.LowPurple
import com.example.meditationappui.ui.theme.LowYellow
import com.example.meditationappui.ui.theme.MediumGreen
import com.example.meditationappui.ui.theme.MediumOrange
import com.example.meditationappui.ui.theme.MediumPurple
import com.example.meditationappui.ui.theme.MediumYellow
import com.example.meditationappui.ui.theme.Orange


@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CalmBlue)
            .padding(10.dp)
    ) {
        Column {
            Greeting(name = "Serban")
            SelectorSection(chips = listOf("Deep Thoughts", "Sleep Improvement", "Relaxation"))
            CurrentMeditation()
            FeaturedSection(
                features = listOf(
                    Feature(
                        "Sleep Meditation",
                        R.drawable.headphones,
                        HighGreen,
                        MediumGreen,
                        LowGreen
                    ),
                    Feature(
                        "Tips for Sleeping",
                        R.drawable.video,
                        HighPurple,
                        MediumPurple,
                        LowPurple
                    ),
                    Feature("Night Island", R.drawable.video, HighYellow, MediumYellow, LowYellow),
                    Feature(
                        "Calming Sounds",
                        R.drawable.headphones,
                        HighOrange,
                        MediumOrange,
                        LowOrange
                    )
                )
            )
        }
        BottomNavMenu(
            itemList = listOf(
                Item("Home", R.drawable.home),
                Item("Meditation", R.drawable.meditation),
                Item("Sleep", R.drawable.sleep),
                Item("Music", R.drawable.music),
                Item("Profile", R.drawable.account)
            ),
            modifier = Modifier
            .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Greeting(name: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column {
            Text(
                text = "Hello $name!",
                color = Color.White,
                fontSize = 25.sp
            )
            Text(
                text = "We wish you have a good day!",
                color = Color.White,
                fontSize = 20.sp
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(40.dp)
        )
    }
}

@Composable
fun SelectorSection(chips: List<String>) {

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {
        items(chips.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 10.dp, top = 20.dp, bottom = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable {
                        selectedIndex = it
                    }
                    .background(
                        if (selectedIndex == it) DarkBlue else Color.Gray
                    )
                    .padding(15.dp)
            ) {
                Text(
                    text = chips[it],
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun CurrentMeditation() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 25.dp, start = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Orange)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()

    ) {
        Column {
            Text(
                text = "Daily Thought",
                color = Color.White,
                fontSize = 25.sp
            )
            Text(
                text = "Meditation · 3-10 min",
                color = Color.White,
                fontSize = 18.sp
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(CircleShape)
                .background(DarkBlue)
                .size(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.play),
                contentDescription = null,
                modifier = Modifier
                    .size(35.dp)
                    .clickable {

                    }

            )
        }

    }
}

@Composable
fun FeaturedSection(features: List<Feature>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Featured",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(15.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp, end = 7.5.dp, bottom = 100.dp),
            modifier = Modifier
                .fillMaxHeight()
                //.padding(top = 10.dp)
        ) {
            items(features.size) {
                FeaturedItem(feature = features[it])
            }
        }
    }
}

@Composable
fun FeaturedItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(10.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.highColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight

        //Medium Colored Path
        val mediumPoint1 = Offset(0f, 0.3f * height)
        val mediumPoint2 = Offset(0.1f * width, 0.4f * height)
        val mediumPoint3 = Offset(0.2f * width, 0.2f * height)
        val mediumPoint4 = Offset(0.4f * width, 0.7f * height)
        val mediumPoint5 = Offset(1.5f * width, -height.toFloat())
        val mediumPoint6 = Offset(1.8f * width, -height.toFloat())

        val mediumPath = Path().apply {
            moveTo(mediumPoint1.x, mediumPoint1.y)
            curveFromTo(mediumPoint1, mediumPoint2)
            curveFromTo(mediumPoint2, mediumPoint3)
            curveFromTo(mediumPoint3, mediumPoint4)
            curveFromTo(mediumPoint4, mediumPoint5)
            curveFromTo(mediumPoint5, mediumPoint6)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)

            close()
        }

        //Low Colored Path
        val lowPoint1 = Offset(0f, 0.5f * height)
        val lowPoint2 = Offset(0.1f * width, 0.6f * height)
        val lowPoint3 = Offset(0.2f * width, 0.3f * height)
        val lowPoint4 = Offset(0.4f * width, 0.8f * height)
        val lowPoint5 = Offset(1.8f * width, -height.toFloat())

        val lowPath = Path().apply {
            moveTo(lowPoint1.x, lowPoint1.y)
            curveFromTo(lowPoint1, lowPoint2)
            curveFromTo(lowPoint2, lowPoint3)
            curveFromTo(lowPoint3, lowPoint4)
            curveFromTo(lowPoint4, lowPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)

            close()
        }

        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            drawPath(
                path = mediumPath,
                color = feature.mediumColor
            )
            drawPath(
                path = lowPath,
                color = feature.lowColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Text(
                text = feature.title,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.TopStart)
            )
            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .size(50.dp)
            )
            Button(
                modifier = Modifier
                    .align(Alignment.BottomEnd),
                onClick = {

                }) {
                Text(
                    text = "Start",
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}

@Composable
fun BottomNavMenu(
    itemList: List<Item>,
    initialValue: Int = 0,
    modifier: Modifier
) {

    var selectedItem by remember {
        mutableStateOf(initialValue)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .background(CalmBlue)
            .padding(top = 20.dp)
    ) {
        itemList.forEachIndexed { index, item ->
            BottomNavMenuItem(
                item = item, isSelected = index == selectedItem
            ) {
                selectedItem = index
            }
        }
    }
}

@Composable
fun BottomNavMenuItem(
    item: Item,
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable {
                onItemClick()
            }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) DarkBlue else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
            )
        }
        Text(
            text = item.title,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier
                .padding(top = 5.dp)
        )
    }
}

@Preview
@Composable
fun Preview() {
    //Greeting("Serban")
    //SelectorSection(chips = listOf("Deep Thoughts", "Sleep Improvement", "Relaxation"))
    //CurrentMeditation()
    /*
    FeaturedItem(
        feature = Feature(
            "SleepMeditation",
            R.drawable.headphones,
            HighGreen,
            MediumGreen,
            LowGreen
        )
    )
    */
    /*
    BottomNavMenu(itemList = listOf(
        Item("Home", R.drawable.home),
        Item("Meditation", R.drawable.meditation),
        Item("Sleep", R.drawable.sleep),
        Item("Music", R.drawable.music),
        Item("Profile", R.drawable.account))
    )
    */
    //HomeScreen()
}