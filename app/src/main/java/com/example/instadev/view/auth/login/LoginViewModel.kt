package com.example.instadev.view.auth.login

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instadev.domain.usecases.LoginUseCase
import com.example.instadev.view.state.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val loginUseCase: LoginUseCase
) : ViewModel() {
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

    fun onClickSelected() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = loginUseCase(_uiState.value.email, _uiState.value.password)
            withContext(Dispatchers.Main) {
                if (response != null) {
                    Log.i("LOGIN", "SUCCESS ${response.name}")
                } else {
                    Log.i("LOGIN", "ERROR")
                }
            }
        }
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
