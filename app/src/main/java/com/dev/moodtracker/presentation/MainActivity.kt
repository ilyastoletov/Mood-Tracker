package com.dev.moodtracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.moodtracker.presentation.screens.auth.login.view.LoginScreen
import com.dev.moodtracker.presentation.screens.auth.register.view.RegisterScreen
import com.dev.moodtracker.presentation.theme.Background
import com.dev.moodtracker.presentation.theme.MoodTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodTrackerTheme {
                Box(modifier = Modifier.fillMaxSize().background(Background)) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") { LoginScreen(navController) }
                        composable("register") { RegisterScreen(navController) }
                    }
                }
            }
        }
    }
}