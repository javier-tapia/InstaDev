package com.example.instadev.view.auth.login

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.R

@Preview
@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = "Español (Latinoamérica)"
            )
            Spacer(modifier = Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = "InstaDev logo"
            )
            Spacer(modifier = Modifier.weight(1f))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24),
                value = uiState.email,
                label = {
                    Text("Usuario, email o teléfono")
                },
                onValueChange = { loginViewModel.onEmailChanged(it) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24),
                value = uiState.password,
                label = {
                    Text("Contraseña")
                },
                onValueChange = { loginViewModel.onPasswordChanged(it) }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = uiState.isLoginEnabled,
                onClick = { }
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 4.dp),
                    text = "Iniciar sesión"
                )
            }
            TextButton(
                onClick = {}
            ) {
                Text("¿Has olvidado la contraseña?")
            }
            Spacer(modifier = Modifier.weight(1.3f))
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text("Crear cuenta nueva")
            }
            Icon(
                modifier = Modifier.width(60.dp).padding(vertical = 22.dp),
                painter = painterResource(R.drawable.ic_meta),
                tint = Color.Gray,
                contentDescription = "Logo Meta"
            )
        }
    }
}
