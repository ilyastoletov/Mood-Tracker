package com.dev.moodtracker.presentation.screens.auth.register.contract

import androidx.lifecycle.viewModelScope
import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.usecase.auth.RegisterUseCase
import com.dev.domain.utils.Response
import com.dev.moodtracker.presentation.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) :
    BaseViewModel<RegisterContract.Event, RegisterContract.State, RegisterContract.Effect>() {

    override fun setInitialState(): RegisterContract.State = RegisterContract.State.WaitUserInput

    override fun handleEvents(event: RegisterContract.Event) = when(event) {
        is RegisterContract.Event.SendRegisterCredentials -> registerUser(event.login, event.password)
        is RegisterContract.Event.NavigateToLoginScreen -> setEffect { RegisterContract.Effect.NavigateToLogin }
    }

    private fun registerUser(login: String, password: String) {
        viewModelScope.launch(dispatcher) {
            when(val result = registerUseCase.invoke(AuthCredentials(login = login, password = password))) {
                is Response.Success.Data -> if(result.data) {
                    setEffect { RegisterContract.Effect.SuccessfulRegistration }
                } else {
                    setEffect { RegisterContract.Effect.ShowErrorToast("Регистрация не прошла. Проверьте введенные данные и повторите попытку") }
                }
                is Response.Error -> setEffect { RegisterContract.Effect.ShowErrorToast(result.errorMessage) }
                is Response.Success.Empty -> setEffect { RegisterContract.Effect.ShowErrorToast("Получен пустой ответ от сервера") }
            }
        }
    }

}