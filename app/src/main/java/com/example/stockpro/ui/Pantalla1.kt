package com.example.stockpro.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun Pantalla1(nav: NavController) {

    var nombre by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título grande, centrado y con color personalizado
        Text(
            text = "Bienvenido a StockPro",
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 34.sp,
            color = Color(0xFF6A4FB0), // morado personalizado; sustituye por otro hex si quieres
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del operario") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            enabled = nombre.length >= 3,
            onClick = { nav.navigate("catalogo/$nombre") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text("Ingresar al Sistema")
        }
    }
}