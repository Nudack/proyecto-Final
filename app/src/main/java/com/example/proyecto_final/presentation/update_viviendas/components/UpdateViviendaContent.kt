package com.example.proyecto_final.presentation.update_viviendas.components

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
import com.example.proyecto_final.core.Constants.Companion.DESCRIPCION
import com.example.proyecto_final.core.Constants.Companion.NOMBRE
import com.example.proyecto_final.core.Constants.Companion.TIPO
import com.example.proyecto_final.core.Constants.Companion.UPDATE
import com.example.proyecto_final.domain.model.Vivienda
import java.io.IOException

@Composable
fun UpdateViviendaContent(
    padding: PaddingValues,
    vivienda: Vivienda,
    updateTipo: (tipo: String) -> Unit,
    updateNombre: (nombre: String) -> Unit,
    updateDescripcion: (descripcion: String) -> Unit,
    updateImagen: (imagen: Bitmap?) -> Unit,
    updateVivienda: (vivienda: Vivienda) -> Unit,
    navigateBack: () -> Unit
){
    val context = LocalContext.current
    val img: Bitmap = BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
    var bitmap: Bitmap? = null

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) {
        if (it != null) {
            bitmap = it
        }
    }

    val launchImage = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageUri ->
            try {
                if(Build.VERSION.SDK_INT < 28){
                    bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
                } else {
                    val source = ImageDecoder.createSource(context.contentResolver, imageUri)
                    bitmap = ImageDecoder.decodeBitmap(source)
                }
            } catch (e: IOException) {
                // Maneja cualquier error de lectura de la imagen aquí
                e.printStackTrace()
            }
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = vivienda.tipo,
            onValueChange = {tipo ->
                updateTipo(tipo)
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
            value = vivienda.nombre,
            onValueChange = {nombre ->
                updateNombre(nombre)
            },
            placeholder = {
                Text(text = NOMBRE)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        TextField(
            value = vivienda.descripcion,
            onValueChange = {descripcion ->
                updateDescripcion(descripcion)
            },
            placeholder = {
                Text(text = DESCRIPCION)
            }
        )
        Spacer(
            modifier = Modifier
                .height(8.dp)
        )
        bitmap?.let {
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(15.dp)
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
            )
        }
        Row {
            IconButton(onClick = { launcher.launch() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                    contentDescription = null)
            }
            IconButton(onClick = { launchImage.launch("image/*") }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_image_search_24),
                    contentDescription = null)
            }
        }
        Button(
            onClick = {
                updateVivienda(vivienda)
                navigateBack()
            }) {
            Text(text = UPDATE)
        }
    }
}