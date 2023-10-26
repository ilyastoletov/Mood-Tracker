package com.dev.domain.model.mood

import com.dev.domain.model.mood.enumeration.MoodTypeEnum

data class Mood(
    val moodType: MoodTypeEnum,
    val fullText: String,
    val creatingDate: String,
)
