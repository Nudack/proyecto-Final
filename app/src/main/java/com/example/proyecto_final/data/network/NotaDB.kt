package com.example.proyecto_final.data.network

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto_final.domain.model.Nota

@Database (entities = [Nota::class], version = 1, exportSchema = false)
abstract class NotaDB: RoomDatabase() {
    abstract fun notaDao(): NotaDao
}