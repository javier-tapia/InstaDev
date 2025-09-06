package com.example.instadev.view.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instadev.view.core.components.InstaDevButton
import com.example.instadev.view.core.components.InstaDevText

@Preview
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel()) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            InstaDevText(
                text = "¿Cuál es tu número de celular?",
                style = MaterialTheme.typography.titleLarge
            )
            InstaDevText(
                text = "Introduce tu número de celular de contacto. Nadie lo verá en tu perfil",
                style = MaterialTheme.typography.titleMedium
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                label = {
                    InstaDevText(
                        text = "Número de celular"
                    )
                },
                onValueChange = { }
            )
            InstaDevText(
                text = "Puede que recibas notificaciones nuestras en WhatsApp y por SMS por motivos de seguridad y para iniciar sesión.",
            )
            InstaDevButton(
                buttonText = "Siguiente",
                onClick = { }
            )
            OutlinedButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { }
            ) {
                InstaDevText(
                    text = "Registrarte con tu correo electrónico"
                )
            }
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                TextButton(
                    onClick = { }
                ) {
                    InstaDevText(
                        text = "Buscar mi cuenta"
                    )
                }
            }
        }
    }
}
