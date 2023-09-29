package com.dev.moodtracker.presentation.screens.auth.login.view

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import com.dev.moodtracker.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.dev.moodtracker.presentation.screens.auth.login.contract.LoginContract
import com.dev.moodtracker.presentation.screens.auth.login.contract.LoginViewModel
import com.dev.moodtracker.presentation.ui.auth.LoginField
import com.dev.moodtracker.presentation.ui.auth.PasswordField
import com.dev.moodtracker.presentation.ui.main.GreenButton


@Composable
fun LoginScreen(navController: NavController, vm: LoginViewModel = hiltViewModel()) {
    val state by vm.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    when(state) {
        is LoginContract.State.WaitingInput -> LoginContent(onEvent = vm::handleEvents, navController = navController)
    }

    LaunchedEffect(Unit) {
        vm.effect.collect {effect ->
            when(effect) {
                is LoginContract.Effect.SuccessLogin -> { navController.navigate("main") }
                is LoginContract.Effect.ShowErrorToast -> Toast.makeText(context, effect.errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

}

@Composable
private fun LoginContent(
    onEvent: (LoginContract.Event) -> Unit,
    navController: NavController,
) {

    var loginValue by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue()) }
    var passwordValue by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue()) }

    val isPasswordNotEmpty = passwordValue.text.isNotEmpty()
    val isLoginNotEmpty = loginValue.text.isNotEmpty()

    val isFieldsNotEmpty = isPasswordNotEmpty && isLoginNotEmpty

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 15.dp, end = 15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Image(modifier = Modifier
            .width(150.dp)
            .height(150.dp), painter = painterResource(id = R.drawable.logo), contentDescription = "logo", contentScale = ContentScale.Fit)
        Text(
            text = stringResource(R.string.sign_in),
            style = TextStyle(
                fontSize = 32.sp,
                fontFamily = FontFamily(Font(R.font.inter_700)),
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            )
        )
        LoginField(
            value = loginValue,
            onValueChange = { loginValue = it },
        )
        PasswordField(
            value = passwordValue,
            onValueChange = { passwordValue = it },
        )
        GreenButton(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), label = "Войти") {
            if (isFieldsNotEmpty) {
                onEvent(LoginContract.Event.OnLogin(login = loginValue.text, password = passwordValue.text))
            }
        }
        ClickableText(
            text = AnnotatedString(text = stringResource(id = R.string.register)),
            style = TextStyle(textDecoration = TextDecoration.Underline, color = Color(0xFF4AA1F1), fontSize = 16.sp),
            onClick = { navController.navigate("register") }
        )
    }

}