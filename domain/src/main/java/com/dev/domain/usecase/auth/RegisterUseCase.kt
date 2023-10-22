package com.dev.domain.usecase.auth

import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository) {
    suspend fun invoke(credentials: AuthCredentials) = repository.register(credentials)
}