package com.example.instadev.view.state

data class RegisterUiState(
    val registerOption: RegisterOption = RegisterOption.CELLPHONE,
    val inputText: String = "",
    val isRegisterEnabled: Boolean = false,
) {
    enum class RegisterOption {
        CELLPHONE,
        EMAIL
    }
}
