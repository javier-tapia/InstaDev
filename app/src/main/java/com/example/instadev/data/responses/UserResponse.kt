package com.example.instadev.data.responses

import com.example.instadev.domain.entities.UserEntity
import com.example.instadev.domain.entities.UserMode.COMPANY_USER
import com.example.instadev.domain.entities.UserMode.CONTENT_CREATOR_USER
import com.example.instadev.domain.entities.UserMode.REGULAR_USER
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("user_id")
    val userId: String,
    @SerialName("name")
    val name: String,
    @SerialName("nickname")
    val nickname: String,
    @SerialName("followers")
    val followers: Int,
    @SerialName("following")
    val following: List<String>,
    @SerialName("user_type")
    val userType: Int,
)

fun UserResponse.toDomain(): UserEntity {
    val userMode = when(userType) {
        REGULAR_USER.userType -> REGULAR_USER
        CONTENT_CREATOR_USER.userType -> CONTENT_CREATOR_USER
        COMPANY_USER.userType -> COMPANY_USER
        else -> REGULAR_USER
    }

    return UserEntity(
        userId = userId,
        name = name,
        nickname = nickname,
        followers = followers,
        following = following,
        userMode = userMode
    )
}
