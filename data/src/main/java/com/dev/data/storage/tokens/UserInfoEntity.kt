package com.dev.data.storage.tokens

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userInfo")
data class UserInfoEntity(
    @PrimaryKey
    val userId: String,
    val credentialsHash: String
)
