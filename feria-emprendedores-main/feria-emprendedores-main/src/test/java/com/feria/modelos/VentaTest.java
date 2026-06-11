package com.feria.modelos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class VentaTest {

    private final Emprendedor emp = new Emprendedor("Ana", "E001", "3423456789", "ana@mail.com", Categoria.COMIDA);
    private final Producto prod = new Producto("Empanadas", 500.0, 50, emp);

    @Test
    void calcularTotalConDescuentoSinDescuento() {
        Venta v = new Venta("V001", emp, prod, 5, 500.0, LocalDate.now());
        assertEquals(2500.0, v.calcularTotalConDescuento(), 0.001);
    }

    @Test
    void calcularTotalConDescuentoPorCantidad() {
        Venta v = new Venta("V001", emp, prod, 11, 500.0, LocalDate.now());
        double esperado = 5500.0 * 0.9;
        assertEquals(esperado, v.calcularTotalConDescuento(), 0.001);
    }

    @Test
    void calcularTotalConDescuentoPorMonto() {
        Venta v = new Venta("V001", emp, prod, 10, 600.0, LocalDate.now());
        double esperado = 6000.0 * 0.95;
        assertEquals(esperado, v.calcularTotalConDescuento(), 0.001);
    }
}
