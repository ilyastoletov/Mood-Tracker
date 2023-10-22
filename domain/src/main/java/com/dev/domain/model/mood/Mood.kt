package com.dev.domain.model.mood

import androidx.annotation.DrawableRes

data class Mood(
    @DrawableRes
    val moodEmojiIconRes: Int,
    val moodTitle: String,
    val shortText: String,
    val fullText: String,
    val creatingDate: String,
)
