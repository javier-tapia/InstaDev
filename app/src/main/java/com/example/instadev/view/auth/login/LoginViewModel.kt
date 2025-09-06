package com.example.instadev.view.auth.login

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.instadev.view.state.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChanged(email: String) {
        _uiState.update { uiState ->
            uiState.copy(email = email)
        }
        validateLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update { uiState ->
            uiState.copy(password = password)
        }
        validateLogin()
    }

    private fun validateLogin() {
        val isLoginEnabled =
            isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update { uiState ->
            uiState.copy(isLoginEnabled = isLoginEnabled)
        }
    }

    private fun isEmailValid(email: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(password: String) =
        password.length >= 6
}
