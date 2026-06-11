package com.feria.servicios.descuentos;

public class DescuentoPorMonto implements Descuento {
    @Override
    public double aplicar(double total, int cantidad) {
        return total > 5000 ? total * 0.95 : total;
    }
}
