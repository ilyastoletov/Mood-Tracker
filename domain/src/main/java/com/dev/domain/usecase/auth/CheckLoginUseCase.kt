package com.dev.domain.usecase.auth

import com.dev.domain.repository.AuthRepository
import kotlinx.coroutines.flow.StateFlow

class CheckLoginUseCase(private val repository: AuthRepository) {
    fun invoke(): StateFlow<Boolean> = repository.isLoggedIn
}