package com.example.instadev.domain.repositories

import com.example.instadev.domain.entities.UserEntity

interface AuthRepository {
    suspend fun doLogin(user: String, password: String): List<UserEntity>
}
