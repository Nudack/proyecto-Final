package com.example.proyecto_final.presentation.viviendas.components

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
import com.example.proyecto_final.core.Constants.Companion.ADD_VIVIENDA
import com.example.proyecto_final.core.Constants.Companion.DISMISS
import com.example.proyecto_final.core.Constants.Companion.NO_VALUE
import com.example.proyecto_final.core.Constants.Companion.TIPO
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA
import com.example.proyecto_final.domain.model.Vivienda
import kotlinx.coroutines.job
import java.io.IOException

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddViviendaAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addVivienda: (vivienda: Vivienda) -> Unit
){
    if(openDialog){
        var nombre by remember { mutableStateOf(NO_VALUE) }
        var tipo by remember { mutableStateOf(NO_VALUE) }
        var descripcion by remember { mutableStateOf(NO_VALUE) }
        var imagen: Bitmap?
        val focusRequester = FocusRequester()

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

        AlertDialog(
            onDismissRequest = { closeDialog },
            title = {
                Text(text = ADD_VIVIENDA)
            },
            text = {
                Column {
                    TextField(
                        value = nombre,
                        onValueChange = {nombre = it},
                        placeholder = {
                            Text(text = VIVIENDA)
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
                        value = tipo,
                        onValueChange = {tipo = it},
                        placeholder ={
                            Text(text = TIPO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = descripcion,
                        onValueChange = {descripcion = it},
                        placeholder ={
                            Text(text = TIPO)
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
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
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    closeDialog()
                    val vivienda = Vivienda(0, nombre, tipo, descripcion, bitmap)
                    addVivienda(vivienda)
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