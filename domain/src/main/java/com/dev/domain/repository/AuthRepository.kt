package com.dev.domain.repository

import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.utils.Response
import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val isLoggedIn: StateFlow<Boolean>
    suspend fun register(userCredentials: AuthCredentials): Response<Boolean>
    suspend fun auth(userCredentials: AuthCredentials): Response<Boolean>
    suspend fun logout()
}