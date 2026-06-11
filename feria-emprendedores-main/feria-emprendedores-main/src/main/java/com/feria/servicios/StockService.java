// StockService.java (nuevo servicio en la capa de servicios)
package com.feria.servicios;

import com.feria.modelos.Emprendedor;

public class StockService {

    public int calcularValorTotalStock(Emprendedor emprendedor) {
        return emprendedor.getProductos().stream()
                .mapToInt(p -> (int) (p.getPrecio() * p.getStock()))
                .sum();
    }
}
