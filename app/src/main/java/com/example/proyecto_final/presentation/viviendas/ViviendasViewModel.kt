package com.example.proyecto_final.presentation.viviendas

import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_final.core.Constants.Companion.NO_VALUE
import com.example.proyecto_final.domain.model.Vivienda
import com.example.proyecto_final.domain.repository.ViviendaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViviendasViewModel @Inject constructor(
    private val repo: ViviendaRepository
): ViewModel() {
    var vivienda by mutableStateOf(Vivienda(0, NO_VALUE, NO_VALUE, NO_VALUE, null))
    var openDialog by mutableStateOf(false)
    var viviendas = repo.getAllViviendasStream()
    //val viviendas = repo.getViviendaStream()

    fun addVivienda(vivienda: Vivienda) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertVivienda(vivienda)
        }
    }

    fun closeDialog() {
        openDialog = false
    }

    fun openDialog() {
        openDialog = true
    }

    fun deleteVivienda(vivienda: Vivienda){
        viewModelScope.launch (Dispatchers.IO){
            repo.deleteVivienda(vivienda)
        }
    }

    fun updateTipo(tipo: String){
        vivienda = vivienda.copy(
            tipo = tipo
        )
    }
    fun updateNombre(nombre: String){
        vivienda = vivienda.copy(
            nombre = nombre
        )
    }
    fun updateDescripcion(descripcion: String){
        vivienda = vivienda.copy(
            descripcion = descripcion
        )
    }
    fun updateImagen(imagen: Bitmap?){
        vivienda = vivienda.copy(
            imagen = imagen
        )
    }

    fun updateVivienda(vivienda: Vivienda) =
        viewModelScope.launch(Dispatchers.IO){
            repo.updateVivienda(vivienda)
        }

    fun getVivienda(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ){
        vivienda = repo.getViviendaStream(id)
    }
}