package com.example.instadev.data.di

import com.example.instadev.data.repositories.AuthRepositoryImpl
import com.example.instadev.domain.repositories.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl()
}
