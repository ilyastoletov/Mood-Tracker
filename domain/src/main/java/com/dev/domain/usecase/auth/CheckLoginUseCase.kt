package com.dev.domain.usecase.auth

import com.dev.domain.repository.AuthRepository
import kotlinx.coroutines.flow.StateFlow

class CheckLoginUseCase(repository: AuthRepository) {
    val invoke: StateFlow<Boolean> = repository.isLoggedIn
}