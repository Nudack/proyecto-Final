package com.example.proyecto_final.presentation.viviendas.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.proyecto_final.domain.model.Vivienda

@Composable
fun DeleteIcon(deleteVivienda: () -> Unit) {
    IconButton(onClick =  deleteVivienda ) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = null
        )
    }
}