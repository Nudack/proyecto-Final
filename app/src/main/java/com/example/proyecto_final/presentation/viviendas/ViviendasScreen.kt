package com.example.proyecto_final.presentation.viviendas

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_SCREEN
import com.example.proyecto_final.presentation.viviendas.components.AddViviendaAlertDialog
import com.example.proyecto_final.presentation.viviendas.components.AddViviendaFloatingActionButton
import com.example.proyecto_final.presentation.viviendas.components.ViviendasContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViviendasScreen(
    viewModel: ViviendasViewModel = hiltViewModel(),
    navigateToUpdateViviendaScreen: (viviendaID: Int) -> Unit
) {
    val viviendas by viewModel.viviendas.collectAsState(initial = emptyList())
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = VIVIENDA_SCREEN) }) },
        content = { padding ->
            ViviendasContent(
                padding = padding,
                viviendas = viviendas,
                deleteVivienda = {
                    vivienda ->
                    viewModel.deleteVivienda(vivienda)
                },
                navigateToUpdateViviendaScreen = navigateToUpdateViviendaScreen
            )
            AddViviendaAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog() },
                addVivienda = { vivienda ->
                    viewModel.addVivienda(vivienda)
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
