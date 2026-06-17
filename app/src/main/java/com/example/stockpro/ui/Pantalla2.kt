package com.example.stockpro.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stockpro.viewmodel.StockViewModel

@Composable
fun Pantalla2(nav: NavController, vm: StockViewModel, nombre: String) {
    var filtroCritico by remember { mutableStateOf(false) }
    val lista = if (filtroCritico) vm.productos.filter { it.stockActual < 5 } else vm.productos

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("StockPro", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Operario: $nombre", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(12.dp))

        // Filtros
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { filtroCritico = false },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!filtroCritico) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Ver Todo")
            }

            Button(
                onClick = { filtroCritico = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (filtroCritico) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.weight(1f)
            ) {
                Text("Stock Crítico")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Lista ocupa el espacio restante
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(lista) { p ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { nav.navigate("detalle/${p.id}") },
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(p.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(String.format("$%.2f", p.precio), style = MaterialTheme.typography.bodyMedium)
                        }

                        Text(
                            "Stock: ${p.stockActual}",
                            color = if (p.stockActual < 5) Color.Red else Color.Unspecified,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }
                }
            }
        }

        // Botón al final (se mantiene en pantalla)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                onClick = { nav.navigate("reporte") },
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text("Reporte")
            }
        }
    }
}