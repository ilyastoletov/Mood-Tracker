package com.dev.moodtracker.presentation.screens.auth.login.contract

import androidx.lifecycle.viewModelScope
import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.usecase.auth.CheckLoginUseCase
import com.dev.domain.usecase.auth.LoginUseCase
import com.dev.domain.usecase.auth.LogoutUseCase
import com.dev.moodtracker.presentation.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    checkLoginUseCase: CheckLoginUseCase,
    private val logoutUseCase: LogoutUseCase)
    : BaseViewModel<LoginContract.Event, LoginContract.State, LoginContract.Effect>() {

    override fun setInitialState(): LoginContract.State = LoginContract.State.WaitingInput

    val isLoggedIn = checkLoginUseCase.invoke


    override fun handleEvents(event: LoginContract.Event) = when(event) {
        is LoginContract.Event.OnLogin -> loginUser(event.login, event.password)
    }

    private fun loginUser(login: String, password: String) {
        viewModelScope.launch(dispatcher) {
            val loginSuccessful = loginUseCase.invoke(AuthCredentials(login, password))
            if (loginSuccessful)
                setEffect { LoginContract.Effect.SuccessLogin }
            else
                setEffect { LoginContract.Effect.ShowErrorToast("Неправильный логин или пароль") }
        }
    }

    @Suppress("unused")
    fun logout() {
        viewModelScope.launch(dispatcher) {
            logoutUseCase.invoke()
        }
    }

}