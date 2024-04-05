package com.example.proyecto_final.domain.repository

import com.example.proyecto_final.domain.model.Nota
import kotlinx.coroutines.flow.Flow

interface NotaRepository {
    fun getAllNotasStream(): Flow<List<Nota>>

    fun getNotaStream(id: Int): Nota

    suspend fun insertNota(nota: Nota)

    suspend fun deleteNota(nota: Nota)

    suspend fun updateNota(nota: Nota)
}