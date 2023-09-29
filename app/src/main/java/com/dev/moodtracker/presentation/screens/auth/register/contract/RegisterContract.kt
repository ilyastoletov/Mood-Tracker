package com.dev.moodtracker.presentation.screens.auth.register.contract

import com.dev.moodtracker.presentation.core.ViewEffect
import com.dev.moodtracker.presentation.core.ViewEvent
import com.dev.moodtracker.presentation.core.ViewState

object RegisterContract {
    sealed class Event : ViewEvent {
        data class SendRegisterCredentials(val login: String, val password: String) : Event()
        object NavigateToLoginScreen : Event()
    }

    sealed class State : ViewState {
        object WaitUserInput : State()
    }

    sealed class Effect : ViewEffect {
        object SuccessfulRegistration : Effect()
        data class ShowErrorToast(val error: String) : Effect()
        object NavigateToLogin : Effect()
    }
}