package com.feria.servicios;

public interface Descuento {
    double aplicar(double total, int cantidad);
}

public class DescuentoPorCantidad implements Descuento {
    @Override
    public double aplicar(double total, int cantidad) {
        return cantidad > 10 ? total * 0.9 : total;
    }
}

public class DescuentoPorMonto implements Descuento {
    @Override
    public double aplicar(double total, int cantidad) {
        return total > 5000 ? total * 0.95 : total;
    }
}
