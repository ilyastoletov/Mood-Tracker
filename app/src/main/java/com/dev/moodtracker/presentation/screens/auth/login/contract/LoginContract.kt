package com.dev.moodtracker.presentation.screens.auth.login.contract

import com.dev.moodtracker.presentation.core.ViewEffect
import com.dev.moodtracker.presentation.core.ViewEvent
import com.dev.moodtracker.presentation.core.ViewState

object LoginContract {

    sealed class Event : ViewEvent {
        data class OnLogin(val login: String, val password: String) : Event()
    }

    sealed class State : ViewState {
        object WaitingInput : State()
    }

    sealed class Effect : ViewEffect {
        object SuccessLogin : Effect()
        data class ShowErrorToast(val errorMessage: String) : Effect()
    }

}