package com.example.instadev.domain.usecases

import com.example.instadev.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(user: String, password: String) {
        if (user.contains("hotmail.com")) {
            return
        }
        authRepository.doLogin(user, password)
    }
}
