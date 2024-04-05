package com.example.proyecto_final.presentation.update_viviendas

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proyecto_final.presentation.update_viviendas.components.UpdateViviendaContent
import com.example.proyecto_final.presentation.update_viviendas.components.UpdateViviendaTopBar
import com.example.proyecto_final.presentation.viviendas.ViviendasViewModel

@Composable
fun UpdateViviendaScreen(
    viewModel: ViviendasViewModel = hiltViewModel(),
     viviendaId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit) {
        viewModel.getVivienda(viviendaId)
    }
    Scaffold (
        topBar = {
            UpdateViviendaTopBar(
                navigateBack = navigateBack
            )
        },
        content = {padding ->
            UpdateViviendaContent(
                padding = padding,
                vivienda = viewModel.vivienda,
                updateTipo = { tipo ->
                    viewModel.updateTipo(tipo)
                },
                updateNombre = { nombre ->
                    viewModel.updateNombre(nombre)
                },
                updateDescripcion = { descripcion ->
                    viewModel.updateDescripcion(descripcion)
                },
                updateImagen = { imagen ->
                    viewModel.updateImagen(imagen)
                },
                updateVivienda = { vivienda ->
                    viewModel.updateVivienda(vivienda)
                },
                navigateBack = navigateBack
            )
        }
    )
}