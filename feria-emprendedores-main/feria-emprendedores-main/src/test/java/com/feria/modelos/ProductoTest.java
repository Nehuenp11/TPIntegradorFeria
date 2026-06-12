package com.feria.modelos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductoTest {

    @Test
    void calcularValorTotalConPrecioYStock() {
        Producto p = new Producto("Empanadas", 500.0, 10, Categoria.COMIDA, "E001");
        assertEquals(5000.0, p.calcularValorTotal());
    }

    @Test
    void calcularValorTotalConStockCero() {
        Producto p = new Producto("Empanadas", 500.0, 0, Categoria.COMIDA, "E001");
        assertEquals(0.0, p.calcularValorTotal());
    }

    @Test
    void calcularValorTotalConPrecioCero() {
        Producto p = new Producto("Muestra", 0.0, 100, Categoria.COMIDA, "E001");
        assertEquals(0.0, p.calcularValorTotal());
    }
}
