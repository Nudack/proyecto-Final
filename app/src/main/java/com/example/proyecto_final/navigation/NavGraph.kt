package com.example.proyecto_final.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import com.example.proyecto_final.R
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.proyecto_final.core.Constants.Companion.NOTA_ID
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_ID
import com.example.proyecto_final.presentation.viviendas.ViviendasScreen
import com.example.proyecto_final.navigation.Screen.*
import com.example.proyecto_final.presentation.update_notas.UpdateNotasScreen
import com.example.proyecto_final.presentation.notas.NotaScreen
import com.example.proyecto_final.presentation.update_viviendas.UpdateViviendaScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    var selectedHome: Boolean = false
    var selectedNota: Boolean = false
    Scaffold(bottomBar = {
        NavigationBar {
            NavigationBarItem(
                selected = selectedNota,
                onClick = {
                    navController.navigate(NotaScreen.route);
                    selectedNota = true
                          },
                icon = {
                    Icon(painter = painterResource(id = R.drawable.outline_note_24),
                        contentDescription = null) })
        NavigationBarItem(
            selected = selectedHome,
            onClick = {
                navController.navigate(ViviendaScreen.route);
                selectedHome = true
                      },
            icon = {
                Icon(Icons.Outlined.Home,
                    contentDescription = null)
            }
        )
    }
    }) { padding ->
        NavHost(
            navController = navController,
            startDestination = ViviendaScreen.route,
            modifier = Modifier.padding(padding)
        ){
            composable( route = ViviendaScreen.route
            ){
                ViviendasScreen(
                    navigateToUpdateViviendaScreen = {
                            viviendaId ->
                        navController.navigate("${UpdateViviendaScreen.route}/$viviendaId")
                    }
                )
            }
            composable(
                route = "${UpdateViviendaScreen.route}/{$VIVIENDA_ID}",
                arguments = listOf(
                    navArgument(VIVIENDA_ID){
                        type = NavType.IntType
                    }
                )
            ){
                    backStackEntry ->
                val viviendaId = backStackEntry.arguments?.getInt(VIVIENDA_ID) ?:0
                UpdateViviendaScreen(
                    viviendaId = viviendaId,
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable(route = NotaScreen.route){
                NotaScreen (
                    navigateToUpdateNotaScreen = {
                            notaId ->
                        navController.navigate("${UpdateNotasScreen.route}/$notaId")
                    }
                )
            }
            composable(
                route = "${UpdateNotasScreen.route}/{$NOTA_ID}",
                arguments = listOf(
                    navArgument(NOTA_ID){
                        type = NavType.IntType
                    }
                )
            ){
                    backStackEntry ->
                val notaId = backStackEntry.arguments?.getInt(NOTA_ID) ?:0
                UpdateNotasScreen(
                    notaId = notaId,
                    navigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

