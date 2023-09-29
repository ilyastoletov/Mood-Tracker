package com.dev.moodtracker.presentation.di

import com.dev.domain.repository.AuthRepository
import com.dev.domain.usecase.auth.CheckLoginUseCase
import com.dev.domain.usecase.auth.LoginUseCase
import com.dev.domain.usecase.auth.LogoutUseCase
import com.dev.domain.usecase.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
class AppModule {

    @Provides
    fun provideRegisterUseCase(repository: AuthRepository) = RegisterUseCase(repository)

    @Provides
    fun provideCheckLoginCase(repository: AuthRepository) = CheckLoginUseCase(repository)

    @Provides
    fun provideLoginUseCase(repository: AuthRepository) = LoginUseCase(repository)

    @Provides
    fun provideLogoutUseCase(repository: AuthRepository) = LogoutUseCase(repository)

}