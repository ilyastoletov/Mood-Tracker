package com.dev.moodtracker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev.moodtracker.presentation.screens.auth.login.contract.LoginViewModel
import com.dev.moodtracker.presentation.screens.auth.login.view.LoginScreen
import com.dev.moodtracker.presentation.screens.auth.register.view.RegisterScreen
import com.dev.moodtracker.presentation.screens.main.view.MainScreen
import com.dev.moodtracker.presentation.theme.Colors
import com.dev.moodtracker.presentation.theme.MoodTrackerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginVm: LoginViewModel = hiltViewModel()
            val isLoggedIn = loginVm.isLoggedIn.collectAsState()

            MoodTrackerTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Colors.Background) {
                    NavigationHost(isLoggedIn.value)
                }
            }
        }
    }
}

@Composable
private fun NavigationHost(isLoggedIn: Boolean) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "main" else "login"
    ) {
        composable("login") { LoginScreen(navController) }
        composable("register") { RegisterScreen(navController) }
        composable("main") { MainScreen(navController) }
    }
}