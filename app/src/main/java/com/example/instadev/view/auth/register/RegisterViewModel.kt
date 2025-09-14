package com.example.instadev.view.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instadev.view.state.RegisterUiState
import com.example.instadev.view.state.RegisterUiState.RegisterOption.CELLPHONE
import com.example.instadev.view.state.RegisterUiState.RegisterOption.EMAIL
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
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
                registerOption = updatedRegisterOption
            )
        }
    }

    fun onInputChanged(input: String) {
        _uiState.update { state ->
            state.copy(
                inputText = input
            )
        }
    }
}
