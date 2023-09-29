package com.dev.data.network.dto

import com.dev.data.storage.tokens.UserInfoEntity

data class RegisterDto(
    val status: Boolean,
    val userId: String = "",
    val hash: String = ""
)

fun RegisterDto.toUserInfo(): UserInfoEntity = UserInfoEntity(
    userId = this.userId,
    credentialsHash = this.hash
)