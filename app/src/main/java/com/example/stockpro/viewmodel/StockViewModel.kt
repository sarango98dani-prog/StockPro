package com.example.stockpro.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.stockpro.model.Producto

class StockViewModel : ViewModel() {

    val productos = mutableStateListOf(
        Producto(1,"Laptop","Alta gama",1200.0,10),
        Producto(2,"Mouse","Inalámbrico",25.0,3),
        Producto(3,"Teclado","Mecánico",60.0,8),
        Producto(4,"Monitor","27 pulgadas",300.0,4),
        Producto(5,"USB","32GB",10.0,0),
        Producto(6,"Audífonos","Bluetooth",45.0,2)
    )

    fun obtenerProducto(id:Int) = productos.find { it.id == id }

    fun actualizarStock(id:Int, nuevo:Int){
        val i = productos.indexOfFirst { it.id == id }
        if(i != -1){
            productos[i] = productos[i].copy(stockActual = nuevo.coerceAtLeast(0))
        }
    }

    fun totalInventario() =
        productos.sumOf { it.precio * it.stockActual }

    fun productosCero() =
        productos.count { it.stockActual == 0 }
}
