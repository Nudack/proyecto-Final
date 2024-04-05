package com.example.proyecto_final.presentation.notas

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proyecto_final.core.Constants
import com.example.proyecto_final.presentation.notas.components.AddNotaAlertDialog
import com.example.proyecto_final.presentation.notas.components.NotasContent
import com.example.proyecto_final.presentation.viviendas.ViviendasViewModel
import com.example.proyecto_final.presentation.viviendas.components.AddViviendaAlertDialog
import com.example.proyecto_final.presentation.viviendas.components.AddViviendaFloatingActionButton
import com.example.proyecto_final.presentation.viviendas.components.ViviendasContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotaScreen(
    viewModel: NotasViewModel = hiltViewModel(),
    navigateToUpdateNotaScreen: (notaID: Int) -> Unit
) {
    val notas by viewModel.notas.collectAsState(initial = emptyList())
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = Constants.NOTAS_SCREEN) }) },
        content = { padding ->
            NotasContent(
                padding = padding,
                notas = notas,
                deleteNota = {
                        nota ->
                    viewModel.deleteNota(nota)
                },
                navigateToUpdateNotaScreen = navigateToUpdateNotaScreen
            )
            AddNotaAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog() },
                addNota = { nota ->
                    viewModel.addNota(nota)
                }
            ) },
        floatingActionButton = {
            AddViviendaFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}