package com.feria.servicios;

public class DescuentoPorMonto implements Descuento {
    @Override
    public double aplicar(double total, int cantidad) {
        return total > 5000 ? total * 0.95 : total;
    }
}
