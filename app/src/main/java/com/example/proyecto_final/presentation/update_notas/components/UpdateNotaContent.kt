package com.example.proyecto_final.presentation.update_notas.components

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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.proyecto_final.R
import com.example.proyecto_final.core.Constants.Companion.NOMBRE
import com.example.proyecto_final.core.Constants.Companion.TIPO
import com.example.proyecto_final.core.Constants.Companion.UPDATE
import com.example.proyecto_final.domain.model.Nota
import com.example.proyecto_final.domain.model.Vivienda
import java.io.IOException

@Composable
fun UpdateNotaContent(
    padding: PaddingValues,
    nota: Nota,
    updateNombreViv: (nombreViv: String) -> Unit,
    updateDescripcion: (descripcion: String) -> Unit,
    updateNota: (nota: Nota) -> Unit,
    navigateBack: () -> Unit
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = nota.nombreViv,
            onValueChange = {nombreViv ->
                updateNombreViv(nombreViv)
            },
            placeholder = {
                Text(text = TIPO)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = nota.descripcion,
            onValueChange = {descripcion ->
                updateDescripcion(descripcion)
            },
            placeholder = {
                Text(text = NOMBRE)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        Button(
            onClick = {
                updateNota(nota)
                navigateBack()
            }) {
            Text(text = UPDATE)
        }
    }
}