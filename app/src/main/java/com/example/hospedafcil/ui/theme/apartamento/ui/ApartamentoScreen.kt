package com.example.hospedafcil.ui.theme.apartamento.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.hospedafcil.R
import com.example.hospedafcil.ui.theme.Carta

val cartas = listOf(
    Carta(R.drawable.casa1, "Descripcion de ejemplo de la apartamento 1", "Apartamento 1"),
    Carta(R.drawable.casa2, "Descripcion de ejemplo de la apartamento 2", "Apartamento 2"),
    Carta(R.drawable.casa3, "Descripcion de ejemplo de la apartamento 3", "Apartamento 3")
)

@Composable
fun ApartamentoScreen(){
    FilledCardExample(cartas = cartas)
}

@Composable
fun FilledCardExample(cartas: List<Carta>) {
    LazyColumn {items(items = cartas) { cadaCarta ->
        Card (Modifier.padding(16.dp)) {
            Column (Modifier.padding(8.dp)) {
                Image(
                    painter = painterResource(id = cadaCarta.imagePath),
                    contentDescription = "imagen o imagenes de la casa",
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.padding(16.dp))

                Text(
                    text = cadaCarta.nombre,
                    textAlign = TextAlign.Start,
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(text = cadaCarta.body)

                Spacer(modifier = Modifier.padding(8.dp))

                Row (Modifier.align(alignment = Alignment.End)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Edit, contentDescription = "edit")
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Delete, contentDescription = "borrar")
                    }
                }
            }
        }
    }
    }
}