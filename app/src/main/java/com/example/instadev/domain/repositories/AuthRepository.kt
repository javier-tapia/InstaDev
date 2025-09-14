package com.example.instadev.domain.repositories

import com.example.instadev.domain.entities.UserEntity

interface AuthRepository {
    fun doLogin(user: String, password: String): UserEntity
}
