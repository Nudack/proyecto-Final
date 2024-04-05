package com.example.proyecto_final.data.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.proyecto_final.core.Constants.Companion.NOTA_TABLE
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_TABLE
import com.example.proyecto_final.domain.model.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNota(nota: Nota)

    @Update
    suspend fun updateNota(nota: Nota)

    @Delete
    suspend fun deleteNota(nota: Nota)

    @Query("SELECT * FROM $NOTA_TABLE WHERE id = :id")
    fun getNota(id: Int): Nota

    @Query("SELECT * FROM $NOTA_TABLE ORDER BY nombreViv ASC")
    fun getAllNotas(): Flow<List<Nota>>
}