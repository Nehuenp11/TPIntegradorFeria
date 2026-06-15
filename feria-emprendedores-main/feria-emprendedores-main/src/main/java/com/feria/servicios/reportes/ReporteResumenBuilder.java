package com.feria.servicios.reportes;

import com.feria.modelos.Emprendedor;

public class ReporteResumenBuilder implements ReporteBuilder {

    private final StringBuilder reporte = new StringBuilder();

    @Override
    public void agregarHeader(String titulo) {
        reporte.append("========== ").append(titulo).append(" ==========\n");
    }

    @Override
    public void agregarEmprendedor(Emprendedor e) {
    }

    @Override
    public void agregarLinea(String linea) {
        reporte.append(linea).append("\n");
    }

    @Override
    public void agregarSeparador() {
        reporte.append("=======================================\n");
    }

    @Override
    public String construir() {
        return reporte.toString();
    }
}
