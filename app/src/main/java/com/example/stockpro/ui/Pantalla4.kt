package com.example.stockpro.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.stockpro.viewmodel.StockViewModel

// Función usada por NavGraph — recibe NavController y ViewModel
@Composable
fun Pantalla4(nav: NavController, vm: StockViewModel) {
    Pantalla4Content(onBack = { nav.popBackStack() })
}

// Contenido reutilizable y fácil de previsualizar
@Composable
fun Pantalla4Content(onBack: () -> Unit = {}) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Pantalla 4 - Reporte")
        Button(onClick = onBack, modifier = Modifier.padding(top = 8.dp)) {
            Text("Volver")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Pantalla4Preview() {
    Pantalla4Content()
}