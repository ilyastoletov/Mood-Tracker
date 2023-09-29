package com.dev.data.di

import android.content.Context
import androidx.room.Room
import com.dev.data.config.Routes
import com.dev.data.network.ApiClient
import com.dev.data.repository.AuthRepoImpl
import com.dev.data.storage.MoodTrackerDatabase
import com.dev.data.storage.tokens.TokenDao
import com.dev.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Routes.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApiClient(retrofit: Retrofit): ApiClient = retrofit.create(ApiClient::class.java)

    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context): MoodTrackerDatabase = Room
        .databaseBuilder(context, MoodTrackerDatabase::class.java, "mood_tracker.db")
        .build()

    @Provides
    @Singleton
    fun provideTokensDao(database: MoodTrackerDatabase): TokenDao = database.getTokensDao()

    @Provides
    @Singleton
    fun provideAuthRepository(apiClient: ApiClient, dao: TokenDao): AuthRepository {
        return AuthRepoImpl(apiClient, dao)
    }

}