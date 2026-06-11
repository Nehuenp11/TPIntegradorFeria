// src/com/feria/servicios/descuentos/DescuentoStrategy.java
package com.feria.servicios.descuentos;

public interface DescuentoStrategy {
    /**
     * Aplica un descuento sobre el total de la venta.
     *
     * @param total    monto total calculado (cantidad * precioUnitario)
     * @param cantidad cantidad de productos vendidos
     * @return monto final con descuento aplicado
     */
    double aplicarDescuento(double total, int cantidad);
}
