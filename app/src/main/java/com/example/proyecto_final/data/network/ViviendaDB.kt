package com.example.proyecto_final.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto_final.domain.model.Nota
import com.example.proyecto_final.domain.model.Vivienda

@Database (entities = [Vivienda::class], version = 1, exportSchema = false)
abstract class ViviendaDB: RoomDatabase() {
    abstract fun viviendaDao(): ViviendaDao
}