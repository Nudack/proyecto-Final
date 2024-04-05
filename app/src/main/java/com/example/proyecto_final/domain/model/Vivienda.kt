package com.example.proyecto_final.domain.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.proyecto_final.core.BitmapTypeConverter
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_TABLE


//entidad Casa para las casas que se quieran guardar en la app
@Entity(tableName = VIVIENDA_TABLE)
@TypeConverters(BitmapTypeConverter::class)
data class Vivienda(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tipo: String,
    val nombre: String,
    val descripcion: String,
    val imagen: Bitmap?
)