package com.dev.moodtracker.presentation.ui.main

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.moodtracker.presentation.theme.ButtonGreen

@Composable
fun GreenButton(modifier: Modifier, label: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonGreen
        ),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(text = label, color = Color.White)
    }
}