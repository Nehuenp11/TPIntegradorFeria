package com.feria.utils;

import com.feria.modelos.Producto;

class ProductoFormatter {

    public static String formatear(Producto p) {
        return p.getNombre() + " - $" + p.getPrecio() + " (stock: " + p.getStock() + ")";
    }
}
