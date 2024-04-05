package com.example.proyecto_final.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.proyecto_final.core.Constants.Companion.VIVIENDA_ID
import com.example.proyecto_final.presentation.viviendas.ViviendasScreen
import  com.example.proyecto_final.navigation.Screen.*
import com.example.proyecto_final.presentation.update_viviendas.UpdateViviendaScreen

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = ViviendaScreen.route
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
    }
}