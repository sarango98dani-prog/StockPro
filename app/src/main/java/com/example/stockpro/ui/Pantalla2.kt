package com.example.stockpro.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.stockpro.viewmodel.StockViewModel

@Composable
fun Pantalla2(nav: NavController, vm: StockViewModel, nombre:String){

    val lista = vm.productos

    Column {

        Text("Operario: $nombre")

        LazyColumn {
            items(lista){ p ->
                Card(modifier = Modifier.clickable {
                    nav.navigate("detalle/${p.id}")
                }) {
                    Text(p.nombre)
                    Text("$${p.precio}")
                    Text(
                        "Stock: ${p.stockActual}",
                        color = if(p.stockActual < 5) Color.Red
                        else Color.Black
                    )
                }
            }
        }

        Button(onClick = { nav.navigate("reporte") }) {
            Text("Reporte")
        }
    }
}