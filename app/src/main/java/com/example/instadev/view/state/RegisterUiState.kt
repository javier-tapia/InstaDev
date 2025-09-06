package com.example.instadev.view.state

data class RegisterUiState(
    val title: String = "",
    val description: String = "",
    val textFieldLabel: String = "",
    val warningMessage: String = "",
    val registerOptionButtonText: String = "",
    val isLoading: Boolean = false,
    val isLoginEnabled: Boolean = false,
)
