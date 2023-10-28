package com.dev.moodtracker.presentation.screens.main.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.moodtracker.presentation.screens.auth.login.contract.LoginViewModel
import com.dev.moodtracker.presentation.theme.Colors
import com.dev.moodtracker.R
import com.dev.moodtracker.presentation.screens.main.model.DemoFullMoodModel
import com.dev.moodtracker.presentation.screens.main.model.FullMoodModel
import com.dev.moodtracker.presentation.ui.mood.MoodCard

@Composable
fun MainScreen(navController: NavController, vm: LoginViewModel = hiltViewModel()) {
    val testMoodList: List<FullMoodModel> = listOf(
        DemoFullMoodModel,
        DemoFullMoodModel,
        DemoFullMoodModel,
    )
    Scaffold(
        containerColor = Colors.Background,
        topBar = { MainScreenHeader() },
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
            LazyColumn(modifier = Modifier.padding(horizontal = 5.dp)) {
                items(testMoodList) {
                    MoodCard(model = it)
                }
            }
        }
    }
}

@Composable
private fun MainScreenHeader() {
    Text(
        modifier = Modifier.padding(top = 20.dp, start = 10.dp, bottom = 20.dp),
        text = stringResource(R.string.my_records),
        style = TextStyle(
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.inter_700))
        )
    )
}
