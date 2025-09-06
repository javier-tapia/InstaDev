package com.example.instadev.view.core.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun InstaDevButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    enabled: Boolean = false,
    onClick: () -> Unit,
    shape: Shape = MaterialTheme.shapes.extraLarge,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        onClick = onClick,
        shape = shape,
        colors = colors,
    ) {
        InstaDevText(
            modifier = Modifier.padding(vertical = 4.dp),
            text = buttonText,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
