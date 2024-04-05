package com.example.proyecto_final.presentation.update_viviendas.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.proyecto_final.core.Constants.Companion.UPDATE_VIVIENDA_SCREEN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateViviendaTopBar(
    navigateBack: () -> Unit 
) {
    TopAppBar(title = {
        Text(text = UPDATE_VIVIENDA_SCREEN)
    },
        navigationIcon = {
            IconButton(onClick = { navigateBack() }) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null)
            }
        }
    )
}