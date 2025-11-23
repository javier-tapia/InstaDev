package com.example.instadev.data.datasources.api

import com.example.instadev.data.responses.UserResponse
import retrofit2.http.GET

interface LoginApiService {
    @GET("doLogin/.json")
    suspend fun doLogin(): List<UserResponse>
}
