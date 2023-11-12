package com.dev.data.network.dto

import com.dev.data.storage.tokens.UserInfoEntity

data class AuthDto(
    val status: Boolean,
    val userId: String = "",
    val credentialsHash: String = ""
)

fun AuthDto.toUserInfo(): UserInfoEntity = UserInfoEntity(
    userId = this.userId,
    credentialsHash = this.credentialsHash
)