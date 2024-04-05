package com.example.proyecto_final.presentation.update_notas

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proyecto_final.presentation.notas.NotasViewModel
import com.example.proyecto_final.presentation.update_notas.components.UpdateNotaContent
import com.example.proyecto_final.presentation.update_notas.components.UpdateNotasTopBar
import com.example.proyecto_final.presentation.update_viviendas.components.UpdateViviendaContent
import com.example.proyecto_final.presentation.update_viviendas.components.UpdateViviendaTopBar

@Composable
fun UpdateNotasScreen(
    viewModel: NotasViewModel = hiltViewModel(),
    notaId: Int,
    navigateBack: () -> Unit
){
    LaunchedEffect(Unit) {
        viewModel.getNota(notaId)
    }
    Scaffold (
        topBar = {
            UpdateNotasTopBar(
                navigateBack = navigateBack
            )
        },
        content = {padding ->
            UpdateNotaContent(
                padding = padding,
                nota = viewModel.nota,
                updateNombreViv = { nombreViv ->
                    viewModel.updateNombreViv(nombreViv)
                },
                updateDescripcion = { descripcion ->
                    viewModel.updateDescripcion(descripcion)
                },
                updateNota = { nota ->
                    viewModel.updateNota(nota)
                },
                navigateBack = navigateBack
            )
        }
    )
}