package com.feria.servicios;

public class DescuentoPorCantidad implements Descuento {
    @Override
    public double aplicar(double total, int cantidad) {
        return cantidad > 10 ? total * 0.9 : total;
    }
}
