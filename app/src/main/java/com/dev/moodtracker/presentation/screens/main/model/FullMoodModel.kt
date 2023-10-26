package com.dev.moodtracker.presentation.screens.main.model

data class FullMoodModel(
    val fullMoodType: MoodType,
    val moodText: String,
    val creationDate: String
)

val DemoFullMoodModel = FullMoodModel(
    fullMoodType = MoodType.Nice,
    moodText = "Сегодня я поел пельменей",
    creationDate = "26.10.23"
)