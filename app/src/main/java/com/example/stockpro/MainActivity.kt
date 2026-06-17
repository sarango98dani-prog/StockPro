package com.example.stockpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import com.example.stockpro.navigation.NavGraph
import com.example.stockpro.viewmodel.StockViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEntry()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppEntry() {
    val vm: StockViewModel = viewModel()
    MaterialTheme {
        Scaffold(
            topBar = {
                SmallTopAppBar(title = { Text("StockPro") })
            },
            modifier = Modifier
        ) { innerPadding ->
            Surface(modifier = Modifier.padding(innerPadding)) {
                NavGraph(vm)
            }
        }
    }
}