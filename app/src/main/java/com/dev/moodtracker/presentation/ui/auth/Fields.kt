package com.dev.moodtracker.presentation.ui.auth

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.dev.moodtracker.R
import com.dev.moodtracker.presentation.theme.Background
import com.dev.moodtracker.presentation.theme.ErrorColor
import com.dev.moodtracker.presentation.theme.Grey
import java.lang.Error

@Composable
fun LoginField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isError: Boolean = false
) {

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(5.dp)),
        label = { Text(text = stringResource(id = R.string.login)) },
        placeholder = { Text(text = stringResource(id = R.string.enter_login)) },
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = stringResource(R.string.uncorrect_login))
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Background,
            focusedContainerColor = Background,
            disabledContainerColor = Grey,
            focusedBorderColor = Color(0xFF5C5C5C),
            unfocusedBorderColor = Color(0xFF5C5C5C),
            errorBorderColor = ErrorColor,
            cursorColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            errorTextColor = Color.White,
            focusedLabelColor = Color(0xFF5C5C5C),
            unfocusedLabelColor = Color(0xFFFFFFFF),
            errorLabelColor = ErrorColor,
            unfocusedPlaceholderColor = Color.White
        )
    )
}

@Composable
fun PasswordField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isError: Boolean = false
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(5.dp)),
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = stringResource(id = R.string.password)) },
        placeholder = { Text(text = stringResource(id = R.string.enter_password)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = stringResource(R.string.min_password_length))
            }
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Background,
            focusedContainerColor = Background,
            disabledContainerColor = Grey,
            focusedBorderColor = Color(0xFF5C5C5C),
            unfocusedBorderColor = Color(0xFF5C5C5C),
            errorBorderColor = ErrorColor,
            cursorColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            errorTextColor = Color.White,
            focusedLabelColor = Color(0xFF5C5C5C),
            unfocusedLabelColor = Color(0xFFFFFFFF),
            errorLabelColor = ErrorColor,
            unfocusedPlaceholderColor = Color.White,
        )
    )
}

@Composable
fun RepeatPasswordField(
    value: TextFieldValue,
    password: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    isError: Boolean = false
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(5.dp)),
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(text = stringResource(R.string.confirm_password)) },
        placeholder = { Text(text = stringResource(R.string.confirm_pass_placeholder)) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        isError = isError,
        supportingText = {
            if (isError) {
                Text(text = stringResource(R.string.passwords_not_match))
            }
        },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Background,
            focusedContainerColor = Background,
            disabledContainerColor = Grey,
            focusedBorderColor = Color(0xFF5C5C5C),
            unfocusedBorderColor = Color(0xFF5C5C5C),
            errorBorderColor = ErrorColor,
            cursorColor = Color.White,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            errorTextColor = Color.White,
            focusedLabelColor = Color(0xFF5C5C5C),
            unfocusedLabelColor = Color(0xFFFFFFFF),
            errorLabelColor = ErrorColor,
            unfocusedPlaceholderColor = Color.White,
        )
    )
}