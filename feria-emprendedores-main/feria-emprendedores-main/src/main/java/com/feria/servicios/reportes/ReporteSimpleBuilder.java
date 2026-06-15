package com.feria.servicios.reportes;

import com.feria.modelos.Emprendedor;

public class ReporteSimpleBuilder implements ReporteBuilder {

    private final StringBuilder reporte = new StringBuilder();

    @Override
    public void agregarHeader(String titulo) {
        reporte.append(titulo).append("\n");
    }

    @Override
    public void agregarEmprendedor(Emprendedor e) {
        reporte.append(e.getNombre()).append("\n");
    }

    @Override
    public void agregarLinea(String linea) {
        reporte.append(linea).append("\n");
    }

    @Override
    public void agregarSeparador() {
    }

    @Override
    public String construir() {
        return reporte.toString();
    }
}
