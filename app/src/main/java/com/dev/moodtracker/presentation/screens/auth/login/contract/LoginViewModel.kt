package com.dev.moodtracker.presentation.screens.auth.login.contract

import androidx.lifecycle.viewModelScope
import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.usecase.auth.CheckLoginUseCase
import com.dev.domain.usecase.auth.LoginUseCase
import com.dev.domain.usecase.auth.LogoutUseCase
import com.dev.domain.utils.Response
import com.dev.moodtracker.presentation.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val checkLoginUseCase: CheckLoginUseCase,
    private val logoutUseCase: LogoutUseCase)
    : BaseViewModel<LoginContract.Event, LoginContract.State, LoginContract.Effect>() {

    override fun setInitialState(): LoginContract.State = LoginContract.State.WaitingInput

    val isLoggedIn: StateFlow<Boolean> = checkLoginUseCase.invoke()

    override fun handleEvents(event: LoginContract.Event) = when(event) {
        is LoginContract.Event.OnLogin -> loginUser(event.login, event.password)
    }

    private fun loginUser(login: String, password: String) {
        viewModelScope.launch(dispatcher) {
            when (val loginResult = loginUseCase.invoke(AuthCredentials(login, password))) {
                is Response.Success.Data -> setEffect { LoginContract.Effect.SuccessLogin }
                is Response.Error -> setEffect { LoginContract.Effect.ShowErrorToast("Неправильный логин или пароль") }
                is Response.Success.Empty -> setEffect { LoginContract.Effect.ShowErrorToast("Получен пустой ответ от сервера") }
            }
        }
    }

    fun logout() {
        viewModelScope.launch(dispatcher) {
            logoutUseCase.invoke()
        }
    }

}