package com.dev.moodtracker.presentation.ui.mood

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.moodtracker.R
import com.dev.domain.model.mood.Mood
import com.dev.moodtracker.presentation.screens.main.model.FullMoodModel
import com.dev.moodtracker.presentation.theme.Colors

@Preview
@Composable
private fun MoodCardPreview() {

}

@Composable
fun MoodCard(model: FullMoodModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier
            .fillMaxWidth(0.3f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                painter = painterResource(id = model.fullMoodType.moodIconDrawable),
                contentDescription = "emoji icon"
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth(0.7f)
            .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = model.fullMoodType.moodTitle,
                    style = TextStyle(
                        color = model.fullMoodType.titleTextColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(
                            Font(R.font.inter_600)
                        )
                    )
                )
                Text(
                    text = model.moodText,
                    style = TextStyle(
                        color = model.fullMoodType.titleTextColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = FontFamily(
                            Font(R.font.inter_600)
                        )
                    )
                )
            }
        }
    }
}