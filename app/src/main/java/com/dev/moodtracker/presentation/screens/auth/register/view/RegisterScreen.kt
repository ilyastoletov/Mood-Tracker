package com.dev.moodtracker.presentation.screens.auth.register.view

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.dev.moodtracker.R
import com.dev.moodtracker.presentation.screens.auth.register.contract.RegisterContract
import com.dev.moodtracker.presentation.screens.auth.register.contract.RegisterViewModel
import com.dev.moodtracker.presentation.theme.MoodTrackerTheme
import com.dev.moodtracker.presentation.ui.auth.LoginField
import com.dev.moodtracker.presentation.ui.auth.PasswordField
import com.dev.moodtracker.presentation.ui.auth.RepeatPasswordField
import com.dev.moodtracker.presentation.ui.main.GreenButton


@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    MoodTrackerTheme {
        Content(onEvent = {})
    }
}

@Composable
fun RegisterScreen(navController: NavController, vm: RegisterViewModel = hiltViewModel()) {

    val state by vm.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    RegisterContent(state = state, onEvent = vm::handleEvents)
    LaunchedEffect(Unit) {
        vm.effect.collect {effect ->
            when(effect) {
                is RegisterContract.Effect.ShowErrorToast -> Toast.makeText(context, effect.error, Toast.LENGTH_SHORT).show()
                is RegisterContract.Effect.SuccessfulRegistration -> {
                    navController.navigate("login")
                    Toast.makeText(context, R.string.successfull_registration, Toast.LENGTH_SHORT).show()
                }
                is RegisterContract.Effect.NavigateToLogin -> navController.navigate("login")
            }
        }
    }

}

@Composable
private fun RegisterContent(state: RegisterContract.State, onEvent: (RegisterContract.Event) -> Unit) {

    when(state) {
        is RegisterContract.State.WaitUserInput -> Content(onEvent)
    }
    
}

@Composable
private fun Content(onEvent: (RegisterContract.Event) -> Unit) {
    
    val context = LocalContext.current

    var loginValue by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue()) }
    var passwordValue by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue()) }
    var repeatPasswordValue by rememberSaveable(stateSaver = TextFieldValue.Saver) { mutableStateOf(TextFieldValue()) }

    val isPasswordNotEmpty = passwordValue.text.isNotEmpty()
    val isLoginNotEmpty = loginValue.text.isNotEmpty()

    val isLoginLengthCorrect = isLoginNotEmpty and (loginValue.text.length in 3..32)
    val isPasswordLengthCorrect = isPasswordNotEmpty and (passwordValue.text.length >= 8)
    val isPasswordsMatch = passwordValue.text == repeatPasswordValue.text


    val isFieldsCorrect = isLoginLengthCorrect && isPasswordLengthCorrect && isPasswordsMatch

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
            text = stringResource(R.string.sign_up),
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
            isError = !isLoginLengthCorrect and isLoginNotEmpty
        )
        PasswordField(
            value = passwordValue,
            onValueChange = { passwordValue = it },
            isError = !isPasswordLengthCorrect and isPasswordNotEmpty
        )
        RepeatPasswordField(
            value = repeatPasswordValue,
            onValueChange = { repeatPasswordValue = it },
            password = passwordValue,
            isError = !isPasswordsMatch
        )
        GreenButton(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp), label = stringResource(R.string.register_button)
        ) {
            if (isFieldsCorrect) {
                onEvent(RegisterContract.Event.SendRegisterCredentials(loginValue.text, passwordValue.text))
            } else {
                Toast.makeText(context, R.string.incorrect_fields, Toast.LENGTH_SHORT).show()
            }
        }
        ClickableText(
            text = AnnotatedString(text = stringResource(id = R.string.sign_in)),
            style = TextStyle(textDecoration = TextDecoration.Underline, color = Color(0xFF4AA1F1), fontSize = 16.sp),
            onClick = { onEvent(RegisterContract.Event.NavigateToLoginScreen) }
        )
    }
}