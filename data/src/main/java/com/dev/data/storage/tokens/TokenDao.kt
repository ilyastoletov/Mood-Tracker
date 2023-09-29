package com.dev.data.storage.tokens

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TokenDao {

    @Insert(entity = UserInfoEntity::class)
    suspend fun addToken(userInfoEntity: UserInfoEntity)

    @Query("SELECT * FROM userInfo")
    suspend fun getUserInfo(): UserInfoEntity

    @Query("DELETE FROM userInfo")
    suspend fun deleteUserInfo()

}