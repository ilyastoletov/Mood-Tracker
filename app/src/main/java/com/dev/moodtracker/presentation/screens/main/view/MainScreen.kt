package com.dev.moodtracker.presentation.screens.main.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dev.moodtracker.presentation.screens.auth.login.contract.LoginViewModel
import com.dev.moodtracker.presentation.ui.main.GreenButton

@Composable
fun MainScreen(navController: NavController, vm: LoginViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        GreenButton(modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(100.dp), label = "Выйти") {
            vm.logout()
            navController.navigate("login")
        }
    }
}