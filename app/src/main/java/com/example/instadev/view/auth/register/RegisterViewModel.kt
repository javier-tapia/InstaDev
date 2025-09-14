package com.example.instadev.view.auth.register

import android.util.Patterns
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instadev.view.state.RegisterUiState
import com.example.instadev.view.state.RegisterUiState.RegisterOption.CELLPHONE
import com.example.instadev.view.state.RegisterUiState.RegisterOption.EMAIL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onRegisterMethodClick() {
        _uiState.update { state ->
            val updatedRegisterOption =
                when (state.registerOption) {
                    CELLPHONE -> EMAIL
                    EMAIL -> CELLPHONE
                }
            state.copy(
                registerOption = updatedRegisterOption,
                inputText = "",
                isRegisterEnabled = false
            )
        }
    }

    fun onInputChanged(input: String) {
        _uiState.update { state ->
            val isRegisterEnabled =
                when (state.registerOption) {
                    CELLPHONE -> input.isDigitsOnly() && input.length >= 10
                    EMAIL -> Patterns.EMAIL_ADDRESS.matcher(input).matches()
                }
            state.copy(
                inputText = input,
                isRegisterEnabled = isRegisterEnabled
            )
        }
    }
}
