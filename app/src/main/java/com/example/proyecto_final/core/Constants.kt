package com.example.proyecto_final.core

class Constants {
    companion object{
        //Room
        const val VIVIENDA_TABLE = "vivenda_table"
        const val NOTA_TABLE = "nota_table"
        const val INVENTARIO_TABLE = "inventario_table"

        //Screens
        const val VIVIENDA_SCREEN = "Vivienda"
        const val UPDATE_VIVIENDA_SCREEN = "Update vivienda"
        const val INVENTARIO_SCREEN = "Inventario"
        const val UPDATE_INVENTARIO_SCREEN = "Update inventario"
        const val NOTAS_SCREEN = "Nota"
        const val UPDATE_NOTAS_SCREEN = "Update nota"

        //Arguments
        const val VIVIENDA_ID = "viviendaId"
        const val NOTA_ID = "notaId"
        const val INVENTARIO_ID = "inventarioId"

        //Actions
        const val ADD_VIVIENDA = "Agregar vivienda"
        const val DELETE_VIVIENDA = "Borrar una vivienda"
        const val ADD_NOTA = "Agregar nota"
        const val DELETE_NOTA = "Borrar una nota"
        const val ADD_INVENTARIO = "Agregar inventario"
        const val DELETE_INVENTARIO = "Borrar una inventario"

        //Buttons
        const val ADD = "Agregar"
        const val DISMISS = "Cancelar"
        const val UPDATE = "Modificar"

        //Placeholders
        const val VIVIENDA = "Tienes un..."
        const val TIPO = "Tipo de vivienda"
        const val NOMBRE = "Nombre de la vivienda"
        const val NOMBREVIV = "Nombre de la vivienda"
        const val DESCRIPCION = "Descripcion..."
        const val NO_VALUE = ""


    }
}