package com.dev.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dev.data.storage.tokens.TokenDao
import com.dev.data.storage.tokens.UserInfoEntity

@Database(entities = [UserInfoEntity::class], version = 1)
abstract class MoodTrackerDatabase : RoomDatabase() {
    abstract fun getTokensDao(): TokenDao
}