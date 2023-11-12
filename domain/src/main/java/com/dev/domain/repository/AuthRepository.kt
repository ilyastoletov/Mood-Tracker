package com.dev.domain.repository

import com.dev.domain.model.auth.AuthCredentials
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val isLoggedIn: StateFlow<Boolean>
    suspend fun register(userCredentials: AuthCredentials): Boolean
    suspend fun auth(userCredentials: AuthCredentials): Boolean
    suspend fun logout()
}