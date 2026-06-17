package com.example.stockpro.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.example.stockpro.viewmodel.StockViewModel

@Composable
fun Pantalla3(nav: NavController, vm: StockViewModel, id:Int){

    val p = vm.obtenerProducto(id)

    if(p != null){

        Column {

            Text(p.nombre)
            Text(p.descripcion)
            Text("Stock: ${p.stockActual}")

            Button(onClick = { vm.actualizarStock(id, p.stockActual + 1) }) {
                Text("+")
            }

            Button(
                enabled = p.stockActual > 0,
                onClick = { vm.actualizarStock(id, p.stockActual - 1) }
            ) {
                Text("-")
            }

            Button(onClick = { nav.popBackStack() }) {
                Text("Guardar y volver")
            }
        }
    }
}