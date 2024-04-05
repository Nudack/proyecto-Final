package com.example.proyecto_final.data.repository

import com.example.proyecto_final.data.network.ViviendaDao
import com.example.proyecto_final.domain.model.Vivienda
import com.example.proyecto_final.domain.repository.ViviendaRepository
import kotlinx.coroutines.flow.Flow

class ViviendaRepositoryImpl (
    private val viviendaDao: ViviendaDao
): ViviendaRepository {
    override fun getAllViviendasStream(): Flow<List<Vivienda>> = viviendaDao.getAllViviendas()
    override fun getViviendaStream(id: Int): Vivienda = viviendaDao.getVivienda(id)
    override suspend fun insertVivienda(vivienda: Vivienda) = viviendaDao.insertVivienda(vivienda)
    override suspend fun deleteVivienda(vivienda: Vivienda) = viviendaDao.deleteVivienda(vivienda)
    override suspend fun updateVivienda(vivienda: Vivienda) = viviendaDao.updateVivienda(vivienda)
}