package com.dev.moodtracker.presentation.screens.main.model


import androidx.annotation.DrawableRes
import com.dev.moodtracker.R
import androidx.compose.ui.graphics.Color

sealed class MoodType(
    @DrawableRes
    val moodIconDrawable: Int,
    val moodTitle: String,
    val titleTextColor: Color
) {

    object VeryBad : MoodType(
        moodIconDrawable = R.drawable.ic_very_bad,
        moodTitle = "Ужасно",
        titleTextColor = Color(0x00FF0F00)
    )

    object Bad : MoodType(
        moodIconDrawable = R.drawable.ic_bad,
        moodTitle = "Плохо",
        titleTextColor = Color(0x00FF7A00)
    )

    object Average : MoodType(
        moodIconDrawable = R.drawable.ic_average,
        moodTitle = "Средне",
        titleTextColor = Color(0x00FF7A00)
    )

    object Good : MoodType(
        moodIconDrawable = R.drawable.ic_nice,
        moodTitle = "Хорошо",
        titleTextColor = Color(0x00FF7A00)
    )

    object Nice : MoodType(
        moodIconDrawable = R.drawable.ic_very_nice,
        moodTitle = "Супер",
        titleTextColor = Color(0x00FF7A00)
    )

}