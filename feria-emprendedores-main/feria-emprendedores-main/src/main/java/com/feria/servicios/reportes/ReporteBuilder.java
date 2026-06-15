package com.feria.servicios.reportes;

import com.feria.modelos.Emprendedor;

public interface ReporteBuilder {
    void agregarHeader(String titulo);
    void agregarEmprendedor(Emprendedor e);
    void agregarLinea(String linea);
    void agregarSeparador();
    String construir();
}
