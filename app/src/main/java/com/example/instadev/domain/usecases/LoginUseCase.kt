package com.example.instadev.domain.usecases

import com.example.instadev.domain.entities.UserEntity
import com.example.instadev.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(user: String, password: String): UserEntity? {
        if (user.contains("hotmail.com")) {
            return null
        }
        val response = authRepository.doLogin(user, password)
        return response.random()
    }
}
