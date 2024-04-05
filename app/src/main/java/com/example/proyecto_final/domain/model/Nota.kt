package com.example.proyecto_final.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.proyecto_final.core.BitmapTypeConverter
import com.example.proyecto_final.core.Constants

@Entity(tableName = Constants.NOTA_TABLE)
@TypeConverters(BitmapTypeConverter::class)
data class Nota(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombreViv: String,
    val descripcion: String,
)