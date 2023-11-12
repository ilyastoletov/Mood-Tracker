package com.dev.moodtracker.presentation.ui.mood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.moodtracker.presentation.screens.main.model.DemoFullMoodModel
import com.dev.moodtracker.presentation.screens.main.model.FullMoodModel
import com.dev.moodtracker.presentation.theme.MoodTrackerTheme

@Preview
@Composable
private fun MoodCardPreview() {
    MoodTrackerTheme {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            MoodCard(model = DemoFullMoodModel)
        }
    }
}

@Composable
fun MoodCard(model: FullMoodModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color(0xFF202020)),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier.background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(10.dp),
                painter = painterResource(id = model.fullMoodType.moodIconDrawable),
                contentDescription = "emoji icon"
            )
        }
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = model.fullMoodType.moodTitle,
                    style = MaterialTheme.typography.displayMedium.copy(
                        color = model.fullMoodType.titleTextColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                )
                Text(
                    text = model.creationDate,
                    style = MaterialTheme.typography.displayMedium.copy(
                        color = Color(0xFF787878),
                        fontSize = 10.sp,
                    )
                )
            }
            Text(
                text = model.moodText,
                style = MaterialTheme.typography.displayMedium.copy(
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                )
            )
        }
    }
}