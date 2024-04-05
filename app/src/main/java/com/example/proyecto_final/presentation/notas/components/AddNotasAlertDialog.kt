package com.example.proyecto_final.presentation.notas.components

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyecto_final.R
import com.example.proyecto_final.core.Constants.Companion.ADD
import com.example.proyecto_final.core.Constants.Companion.ADD_NOTA
import com.example.proyecto_final.core.Constants.Companion.ADD_VIVIENDA
import com.example.proyecto_final.core.Constants.Companion.DESCRIPCION
import com.example.proyecto_final.core.Constants.Companion.DISMISS
import com.example.proyecto_final.core.Constants.Companion.NOMBREVIV
import com.example.proyecto_final.core.Constants.Companion.NO_VALUE
import com.example.proyecto_final.core.Constants.Companion.TIPO
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA
import com.example.proyecto_final.domain.model.Nota
import com.example.proyecto_final.domain.model.Vivienda
import kotlinx.coroutines.job
import java.io.IOException


@Composable
fun AddNotaAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addNota: (nota: Nota) -> Unit
){
    if(openDialog){
        var nombreViv by remember { mutableStateOf(NO_VALUE) }
        var descripcion by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(text = ADD_NOTA)
            },
            text = {
                Column {
                    TextField(
                        value = nombreViv,
                        onValueChange = {nombreViv = it},
                        placeholder = {
                            Text(text = NOMBREVIV)
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = descripcion,
                        onValueChange = {descripcion = it},
                        placeholder ={
                            Text(text = DESCRIPCION)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    closeDialog()
                    val nota = Nota(0, nombreViv, descripcion)
                    addNota(nota)
                }) {
                    Text(text = ADD)
                }
            },
            dismissButton = {
                TextButton(onClick = { closeDialog() }) {
                    Text(text = DISMISS)
                }
            }
        )
    }
}