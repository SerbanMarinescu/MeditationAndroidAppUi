package com.example.meditationappui.data

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val highColor: Color,
    val mediumColor: Color,
    val lowColor: Color,
)