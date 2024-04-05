package com.example.proyecto_final.domain.repository

import com.example.proyecto_final.domain.model.Vivienda
import kotlinx.coroutines.flow.Flow

interface ViviendaRepository {
    fun getAllViviendasStream(): Flow<List<Vivienda>>

    fun getViviendaStream(id: Int): Vivienda

    suspend fun insertVivienda(vivienda: Vivienda)

    suspend fun deleteVivienda(vivienda: Vivienda)

    suspend fun updateVivienda(vivienda: Vivienda)

}