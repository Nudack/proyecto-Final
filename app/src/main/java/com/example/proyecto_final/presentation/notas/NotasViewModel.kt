package com.example.proyecto_final.presentation.notas

import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_final.core.Constants.Companion.NO_VALUE
import com.example.proyecto_final.domain.model.Nota
import com.example.proyecto_final.domain.model.Vivienda
import com.example.proyecto_final.domain.repository.NotaRepository
import com.example.proyecto_final.domain.repository.ViviendaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotasViewModel @Inject constructor(
    private val repo: NotaRepository
): ViewModel() {
    var nota by mutableStateOf(Nota(0, NO_VALUE, NO_VALUE))
    var openDialog by mutableStateOf(false)
    var notas = repo.getAllNotasStream()

    fun addNota(nota: Nota) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertNota(nota)
        }
    }

    fun closeDialog() {
        openDialog = false
    }

    fun openDialog() {
        openDialog = true
    }

    fun deleteNota(nota: Nota){
        viewModelScope.launch (Dispatchers.IO){
            repo.deleteNota(nota)
        }
    }

    fun updateNombreViv(nombreViv: String){
        nota = nota.copy(
            nombreViv = nombreViv
        )
    }
    fun updateDescripcion(descripcion: String){
        nota = nota.copy(
            descripcion = descripcion
        )
    }

    fun updateNota(nota: Nota) =
        viewModelScope.launch(Dispatchers.IO){
            repo.updateNota(nota)
        }

    fun getNota(id: Int) = viewModelScope.launch(
        Dispatchers.IO
    ){
        nota = repo.getNotaStream(id)
    }
}