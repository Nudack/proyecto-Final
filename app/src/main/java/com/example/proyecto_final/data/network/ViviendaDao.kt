package com.example.proyecto_final.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_TABLE
import com.example.proyecto_final.domain.model.Vivienda
import kotlinx.coroutines.flow.Flow

@Dao
interface ViviendaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertVivienda(vivienda: Vivienda)

    @Update
    suspend fun updateVivienda(vivienda: Vivienda)

    @Delete
    suspend fun deleteVivienda(vivienda: Vivienda)

    @Query("SELECT * FROM $VIVIENDA_TABLE WHERE id = :id")
    fun getVivienda(id: Int): Vivienda

    @Query("SELECT * FROM $VIVIENDA_TABLE ORDER BY nombre ASC")
    fun getAllViviendas(): Flow<List<Vivienda>>
}