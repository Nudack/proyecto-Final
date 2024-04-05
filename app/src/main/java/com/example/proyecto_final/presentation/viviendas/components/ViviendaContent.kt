package com.example.proyecto_final.presentation.viviendas.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.proyecto_final.domain.model.Vivienda


@Composable
fun ViviendasContent(
    padding: PaddingValues,
    viviendas: List<Vivienda>,
    deleteVivienda: (vivienda: Vivienda) -> Unit,
    navigateToUpdateViviendaScreen: (viviendaId: Int) -> Unit
){
    LazyColumn (modifier = Modifier
        .fillMaxSize()
        .padding(padding)
    ) {
        items(viviendas){ vivienda ->
            ViviendasCard(
                vivienda = vivienda,
                deleteVivienda = {
                    deleteVivienda(vivienda)
                },
                navigateToUpdateViviendaScreen = navigateToUpdateViviendaScreen
            )
        }
    }
}