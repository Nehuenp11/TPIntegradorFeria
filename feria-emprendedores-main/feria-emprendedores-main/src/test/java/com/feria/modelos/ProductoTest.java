package com.feria.modelos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProductoTest {

    private final Emprendedor emp = new Emprendedor("Ana", "E001", "3423456789", "ana@mail.com", Categoria.COMIDA);

    @Test
    void calcularValorTotalConPrecioYStock() {
        Producto p = new Producto("Empanadas", 500.0, 10, emp);
        assertEquals(5000.0, p.calcularValorTotal());
    }

    @Test
    void calcularValorTotalConStockCero() {
        Producto p = new Producto("Empanadas", 500.0, 0, emp);
        assertEquals(0.0, p.calcularValorTotal());
    }

    @Test
    void calcularValorTotalConPrecioCero() {
        Producto p = new Producto("Muestra", 0.0, 100, emp);
        assertEquals(0.0, p.calcularValorTotal());
    }
}
