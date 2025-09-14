package com.example.instadev.view.state

data class RegisterUiState(
    val registerOption: RegisterOption = RegisterOption.CELLPHONE,
    val inputText: String = "",
    val isRegisterEnabled: Boolean = true,
) {
    enum class RegisterOption {
        CELLPHONE,
        EMAIL
    }
}
