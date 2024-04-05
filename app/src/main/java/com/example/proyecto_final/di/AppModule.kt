package com.example.proyecto_final.di

import android.content.Context
import androidx.room.Room
import com.example.proyecto_final.core.Constants.Companion.NOTA_TABLE
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_TABLE
import com.example.proyecto_final.data.network.NotaDB
import com.example.proyecto_final.data.network.NotaDao
import com.example.proyecto_final.data.network.ViviendaDB
import com.example.proyecto_final.data.network.ViviendaDao
import com.example.proyecto_final.data.repository.NotaRepositoryImpl
import com.example.proyecto_final.data.repository.ViviendaRepositoryImpl
import com.example.proyecto_final.domain.repository.NotaRepository
import com.example.proyecto_final.domain.repository.ViviendaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideViviendaDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
        ViviendaDB::class.java,
        VIVIENDA_TABLE).build()

    @Provides
    fun provideViviendaDao(
        baseDeDatos: ViviendaDB
    ) = baseDeDatos.viviendaDao()

    @Provides
    fun provideViviendaRepository(
        viviendaDao: ViviendaDao
    ): ViviendaRepository = ViviendaRepositoryImpl(
        viviendaDao = viviendaDao
    )
    @Provides
    fun provideNotaDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(context,
        NotaDB::class.java,
        NOTA_TABLE).build()

    @Provides
    fun provideNotaDao(
        baseDeDatos: NotaDB
    ) = baseDeDatos.notaDao()

    @Provides
    fun provideNotaRepository(
        notaDao: NotaDao
    ): NotaRepository = NotaRepositoryImpl(
        notaDao = notaDao
    )
}