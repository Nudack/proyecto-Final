package com.example.proyecto_final.presentation.notas.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.proyecto_final.domain.model.Nota
import com.example.proyecto_final.domain.model.Vivienda
import com.example.proyecto_final.presentation.viviendas.components.ViviendasCard

@Composable
fun NotasContent(
    padding: PaddingValues,
    notas: List<Nota>,
    deleteNota: (nota: Nota) -> Unit,
    navigateToUpdateNotaScreen: (notaId: Int) -> Unit
){
    LazyColumn (modifier = Modifier
        .fillMaxSize()
        .padding(padding)
    ) {
        items(notas){ nota ->
            NotasCard(
                nota = nota,
                deleteNota = {
                    deleteNota(nota)
                },
                navigateToUpdateNotaScreen = navigateToUpdateNotaScreen
            )
        }
    }
}