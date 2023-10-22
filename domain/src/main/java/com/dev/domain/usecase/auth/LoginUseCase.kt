package com.dev.domain.usecase.auth

import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend fun invoke(credentials: AuthCredentials) = repository.auth(credentials)
}