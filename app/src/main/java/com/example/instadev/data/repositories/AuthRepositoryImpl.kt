package com.example.instadev.data.repositories

import android.util.Log
import com.example.instadev.data.datasources.api.LoginApiService
import com.example.instadev.data.responses.toDomain
import com.example.instadev.domain.entities.UserEntity
import com.example.instadev.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val apiService: LoginApiService,
//    val dataSource: LoginDataSource
) : AuthRepository {
    override suspend fun doLogin(user: String, password: String): List<UserEntity> {
        val response = try {
            apiService.doLogin()
        } catch (e: Exception) {
            Log.i("DOLOGIN ERROR", "$e")
            emptyList()
        }
        return response.map {
            it.toDomain()
        }
    }
}
