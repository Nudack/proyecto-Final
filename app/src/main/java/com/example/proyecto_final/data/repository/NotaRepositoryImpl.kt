package com.example.proyecto_final.data.repository

import com.example.proyecto_final.data.network.NotaDao
import com.example.proyecto_final.domain.model.Nota
import com.example.proyecto_final.domain.repository.NotaRepository
import kotlinx.coroutines.flow.Flow

class NotaRepositoryImpl (
    private val notaDao: NotaDao
): NotaRepository {
    override fun getAllNotasStream(): Flow<List<Nota>> = notaDao.getAllNotas()
    override fun getNotaStream(id: Int): Nota = notaDao.getNota(id)
    override suspend fun insertNota(nota: Nota) = notaDao.insertNota(nota)
    override suspend fun deleteNota(nota: Nota) = notaDao.deleteNota(nota)
    override suspend fun updateNota(nota: Nota) = notaDao.updateNota(nota)
}