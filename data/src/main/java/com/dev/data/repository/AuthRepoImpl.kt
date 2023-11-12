package com.dev.data.repository

import com.dev.data.network.ApiClient
import com.dev.data.network.dto.AuthDto
import com.dev.data.network.dto.toUserInfo
import com.dev.data.storage.tokens.TokenDao
import com.dev.data.utils.HashUtil
import com.dev.data.utils.performNetworkOperation
import com.dev.domain.model.auth.AuthCredentials
import com.dev.domain.repository.AuthRepository
import com.dev.domain.utils.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking

class AuthRepoImpl(private val apiClient: ApiClient,
                   private val roomTokenDao: TokenDao) : AuthRepository {

    override val isLoggedIn = MutableStateFlow(
        runBlocking {
            return@runBlocking isAuthorized()
        }
    ).asStateFlow()

    override suspend fun register(userCredentials: AuthCredentials): Boolean {
        return authOperation(userCredentials, true)
    }

    override suspend fun auth(userCredentials: AuthCredentials): Boolean {
        return authOperation(userCredentials, false)
    }

    private suspend fun authOperation(userCredentials: AuthCredentials, register: Boolean): Boolean {
        val hashedCredentials = HashUtil.md5(userCredentials.login + userCredentials.password)
        val operation = performNetworkOperation {
            if (register) {
                apiClient.register(hashedCredentials)
            } else {
                apiClient.login(hashedCredentials)
            }
        }
        if (operation is Response.Success.Data) saveUserDataToRoom(operation.data)
        return operation is Response.Success.Data
    }

    override suspend fun logout() = roomTokenDao.deleteUserInfo()

    private suspend fun isAuthorized(): Boolean = runCatching {
        val tokensFromDb = roomTokenDao.getUserInfo()
        tokensFromDb.userId.isNotEmpty()
    }.getOrDefault(false)

    private suspend fun saveUserDataToRoom(authDto: AuthDto) {
        roomTokenDao.addToken(authDto.toUserInfo())
    }


}