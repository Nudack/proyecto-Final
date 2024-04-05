package com.example.proyecto_final.presentation.viviendas.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.proyecto_final.core.Constants.Companion.ADD_VIVIENDA

@Composable
fun AddViviendaFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = { openDialog() },
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = ADD_VIVIENDA)
    }
}