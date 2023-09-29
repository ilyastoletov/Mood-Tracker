package com.dev.domain.usecase.auth

import com.dev.domain.repository.AuthRepository

class LogoutUseCase(private val repository: AuthRepository) {
    suspend fun invoke() = repository.logout()
}