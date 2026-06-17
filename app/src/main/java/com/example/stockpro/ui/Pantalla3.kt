package com.example.stockpro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.stockpro.viewmodel.StockViewModel

@Composable
fun Pantalla3(nav: NavController, vm: StockViewModel, id: Int) {
    // Leer el producto directamente del ViewModel para que recomponda al actualizarse
    val p = vm.obtenerProducto(id)

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Text(
                text = "StockPro",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            if (p == null) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Producto no encontrado", style = MaterialTheme.typography.bodyLarge)
                }
                return@Column
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = p.nombre,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = p.descripcion,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Stock: ${p.stockActual}",
                    style = MaterialTheme.typography.displaySmall,
                    color = if (p.stockActual <= 0) Color.Red else MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { vm.actualizarStock(id, p.stockActual + 1) },
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        modifier = Modifier.size(64.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("+", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onPrimary)
                    }

                    Button(
                        onClick = { vm.actualizarStock(id, (p.stockActual - 1).coerceAtLeast(0)) },
                        enabled = p.stockActual > 0,
                        shape = CircleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = if (p.stockActual > 0) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.surface),
                        modifier = Modifier.size(64.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text("-", style = MaterialTheme.typography.titleLarge, color = if (p.stockActual > 0) MaterialTheme.colorScheme.onSecondary else MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            ElevatedButton(
                onClick = { nav.popBackStack() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Guardar y volver", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}