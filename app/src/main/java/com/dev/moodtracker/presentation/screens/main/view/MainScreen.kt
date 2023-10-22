package com.dev.moodtracker.presentation.screens.main.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.domain.model.mood.Mood
import com.dev.moodtracker.presentation.screens.auth.login.contract.LoginViewModel
import com.dev.moodtracker.presentation.theme.Colors
import com.dev.moodtracker.R
import com.dev.moodtracker.presentation.ui.main.GreenButton

@Composable
fun MainScreen(navController: NavController, vm: LoginViewModel = hiltViewModel()) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Colors.ButtonGreen,
                onClick = {},
                content = {
                    Icon(
                        painter = rememberVectorPainter(image = Icons.Default.Add),
                        contentDescription = "add icon"
                    )
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp)
            ) {
                item { MainScreenHeader() }
            }
        }
    }
}

@Composable
private fun MainScreenHeader() {
    Text(
        modifier = Modifier.padding(top = 30.dp, start = 10.dp, bottom = 20.dp),
        text = stringResource(R.string.my_records),
        style = TextStyle(
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.inter_700))
        )
    )
}

@Composable
private fun MoodCard(model: Mood) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(Colors.LightGrey),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier
            .fillMaxWidth(0.3f)
            .fillMaxHeight(), contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                painter = painterResource(id = model.moodEmojiIconRes),
                contentDescription = "emoji icon"
            )
        }
    }
}