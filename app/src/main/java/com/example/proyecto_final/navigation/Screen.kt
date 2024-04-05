package com.example.proyecto_final.navigation

import com.example.proyecto_final.core.Constants.Companion.UPDATE_VIVIENDA_SCREEN
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_SCREEN

open class Screen (val route: String) {
    object ViviendaScreen: Screen(VIVIENDA_SCREEN)

    object UpdateViviendaScreen: Screen(UPDATE_VIVIENDA_SCREEN)
}