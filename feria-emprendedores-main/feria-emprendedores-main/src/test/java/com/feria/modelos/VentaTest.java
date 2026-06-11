package com.feria.modelos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class VentaTest {

    @Test
    void calcularTotalConPrecioYCantidad() {
        Venta v = new Venta("V001", "E001", "P001", 5, 500.0, LocalDate.now());
        assertEquals(2500.0, v.calcularTotal(), 0.001);
    }

    @Test
    void constructorRechazaCantidadCero() {
        assertThrows(IllegalArgumentException.class, () ->
            new Venta("V001", "E001", "P001", 0, 500.0, LocalDate.now())
        );
    }

    @Test
    void constructorRechazaPrecioCero() {
        assertThrows(IllegalArgumentException.class, () ->
            new Venta("V001", "E001", "P001", 5, 0.0, LocalDate.now())
        );
    }
}
