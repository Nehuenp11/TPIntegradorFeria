package com.feria.servicios.reportes;

import com.feria.modelos.Emprendedor;
import com.feria.modelos.Producto;

public class ReporteCompletoBuilder implements ReporteBuilder {

    private final StringBuilder reporte = new StringBuilder();

    @Override
    public void agregarHeader(String titulo) {
        reporte.append("=== ").append(titulo).append(" ===\n");
    }

    @Override
    public void agregarEmprendedor(Emprendedor e) {
        reporte.append("Emprendedor: ").append(e.getNombre()).append("\n");
        reporte.append("ID: ").append(e.getIdentificador()).append("\n");
        reporte.append("Contacto: ").append(e.getTelefono()).append(" | ").append(e.getEmail()).append("\n");
        reporte.append("Categoria: ").append(e.getCategoria()).append("\n");
        reporte.append("Productos:\n");
        for (Producto p : e.getProductos()) {
            reporte.append("  - ")
                    .append(p.getNombre())
                    .append(" ($")
                    .append(p.getPrecio())
                    .append(")\n");
        }
    }

    @Override
    public void agregarLinea(String linea) {
        reporte.append(linea).append("\n");
    }

    @Override
    public void agregarSeparador() {
        reporte.append("---\n");
    }

    @Override
    public String construir() {
        return reporte.toString();
    }
}
