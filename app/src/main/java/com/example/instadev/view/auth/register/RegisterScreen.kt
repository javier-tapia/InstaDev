package com.example.instadev.view.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaDevButton
import com.example.instadev.view.core.components.InstaDevText
import com.example.instadev.view.state.RegisterUiState.RegisterOption.CELLPHONE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
    val currentRegisterOption = state.registerOption

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier.clickable { navigateBack() },
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            InstaDevText(
                text = if (currentRegisterOption == CELLPHONE) {
                    stringResource(R.string.register_screen_title_cellphone)
                } else {
                    stringResource(R.string.register_screen_title_email)
                },
                style = MaterialTheme.typography.titleLarge
            )
            InstaDevText(
                text = if (currentRegisterOption == CELLPHONE) {
                    stringResource(R.string.register_screen_subtitle_cellphone)
                } else {
                    stringResource(R.string.register_screen_subtitle_email)
                },
                style = MaterialTheme.typography.titleSmall
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                value = state.inputText,
                label = {
                    InstaDevText(
                        text = if (currentRegisterOption == CELLPHONE) {
                            stringResource(R.string.register_screen_label_cellphone)
                        } else {
                            stringResource(R.string.register_screen_label_email)
                        }
                    )
                },
                onValueChange = {
                    viewModel.onInputChanged(it)
                }
            )
            InstaDevText(
                text = if (currentRegisterOption == CELLPHONE) {
                    stringResource(R.string.register_screen_disclaimer_cellphone)
                } else {
                    stringResource(R.string.register_screen_disclaimer_email)
                },
            )
            InstaDevButton(
                buttonText = stringResource(R.string.register_screen_button_next),
                onClick = { /* TODO */ },
                enabled = state.isRegisterEnabled
            )
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    viewModel.onRegisterMethodClick()
                }
            ) {
                InstaDevText(
                    text = if (currentRegisterOption == CELLPHONE) {
                        stringResource(R.string.register_screen_button_registration_method_cellphone)
                    } else {
                        stringResource(R.string.register_screen_button_registration_method_email)
                    }
                )
            }
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = { /* TODO */ }
                ) {
                    InstaDevText(
                        text = stringResource(R.string.register_screen_textbutton_search_account),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
