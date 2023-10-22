package com.dev.data.repository

import com.dev.data.network.ApiClient
import com.dev.data.network.dto.RegisterDto
import com.dev.data.network.dto.toUserInfo
import com.dev.data.storage.tokens.TokenDao
import com.dev.data.utils.performNetworkOperation
import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.repository.AuthRepository
import com.dev.domain.utils.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.runBlocking
import java.security.MessageDigest

class AuthRepoImpl(private val apiClient: ApiClient,
                   private val roomTokenDao: TokenDao) : AuthRepository {

    private val _isLoggedIn: MutableStateFlow<Boolean> = MutableStateFlow(value = runBlocking {
        val isAuthorized = isAuthorized()
        return@runBlocking isAuthorized
    })

    override val isLoggedIn: StateFlow<Boolean>
        get() = _isLoggedIn

    override suspend fun register(userCredentials: AuthCredentials): Response<Boolean> {
        val hashedCredentials = createMd5HashSum(userCredentials.login + userCredentials.password)
        val registerResult = performNetworkOperation<RegisterDto> { apiClient.register(hashedCredentials) }
        if (registerResult is Response.Success.Data && registerResult.data.status) saveUserDataToRoom(registerResult.data)
        return Response.Success.Data(true)
    }

    override suspend fun auth(userCredentials: AuthCredentials): Response<Boolean> {
        val hashedCredentials = createMd5HashSum(userCredentials.login + userCredentials.password)
        return performNetworkOperation { apiClient.login(hashedCredentials) }
    }

    override suspend fun logout() {
        roomTokenDao.deleteUserInfo()
    }

    private suspend fun isAuthorized(): Boolean {
        val tokensFromDb = roomTokenDao.getUserInfo()
        return try {
            tokensFromDb.userId.isNotEmpty()
        } catch(e: NullPointerException) {
            false
        }
    }

    private suspend fun saveUserDataToRoom(registerDto: RegisterDto) {
        roomTokenDao.addToken(registerDto.toUserInfo())
    }

    private fun createMd5HashSum(hashingString: String): String {
        val sha = MessageDigest.getInstance("SHA-256")
        return sha.digest(hashingString.toByteArray()).toString(Charsets.UTF_8)
    }

}