package com.example.instadev.view.auth.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R
import com.example.instadev.view.core.components.InstaDevButton
import com.example.instadev.view.core.components.InstaDevText

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaDevText(
                modifier = Modifier.padding(top = 22.dp),
                style = MaterialTheme.typography.titleLarge,
                text = stringResource(R.string.login_screen_menu_language)
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = stringResource(R.string.login_screen_content_description_instadev_logo)
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                value = uiState.email,
                label = {
                    InstaDevText(
                        text = stringResource(R.string.login_screen_textfield_user)
                    )
                },
                onValueChange = { loginViewModel.onEmailChanged(it) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.small,
                value = uiState.password,
                label = {
                    InstaDevText(
                        text = stringResource(R.string.login_screen_textfield_password),
                    )
                },
                onValueChange = { loginViewModel.onPasswordChanged(it) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            InstaDevButton(
                buttonText = stringResource(R.string.login_screen_login_button_text),
                enabled = uiState.isLoginEnabled,
                onClick = { }
            )
            TextButton(
                onClick = {}
            ) {
                InstaDevText(
                    text = stringResource(R.string.login_screen_forgot_password_button_text),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.weight(1.3f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                shape = MaterialTheme.shapes.extraLarge,
                border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.primary)
            ) {
                InstaDevText(
                    text = stringResource(R.string.login_screen_create_new_account_button_text),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Icon(
                modifier = Modifier
                    .width(60.dp)
                    .padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = stringResource(R.string.login_screen_content_description_meta_logo)
            )
        }
    }
}
