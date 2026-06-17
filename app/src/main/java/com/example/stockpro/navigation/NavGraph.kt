package com.example.stockpro.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.stockpro.viewmodel.StockViewModel
import com.example.stockpro.ui.*

@Composable
fun NavGraph(vm: StockViewModel) {

    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = "login") {

        composable("login") {
            Pantalla1(nav)
        }

        composable("catalogo/{nombre}",
            arguments = listOf(navArgument("nombre"){ type = NavType.StringType })
        ) {
            Pantalla2(nav, vm, it.arguments?.getString("nombre") ?: "")
        }

        composable("detalle/{id}",
            arguments = listOf(navArgument("id"){ type = NavType.IntType })
        ) {
            Pantalla3(nav, vm, it.arguments?.getInt("id") ?: 0)
        }

        composable("reporte") {
            Pantalla4(nav, vm)
        }
    }
}
