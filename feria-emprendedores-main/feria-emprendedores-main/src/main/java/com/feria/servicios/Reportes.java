package com.feria.servicios;

import com.feria.modelos.*;

public class Reportes {

    public String generarReportePorCategoria(GestorFeria gestor, String categoria) {
        String reporte = "=== REPORTE DE EMPRENDEDORES - CATEGORIA: " + categoria + " ===\n";

        for (Emprendedor emprendedor : gestor.getEmprendedores()) {
            if (coincideCategoria(emprendedor, categoria)) {
                reporte += formatearEmprendedor(emprendedor);
                reporte += "---\n";
            }
        }

        return reporte;
    }

    public String generarReportePorCategoriaAlternativo(GestorFeria gestor, String categoria) {
        String resultado = "REPORTE CATEGORIA " + categoria + "\n";
        for (Emprendedor emprendedor : gestor.getEmprendedores()) {
            if (coincideCategoria(emprendedor, categoria)) {
                resultado += emprendedor.getNombre() + "\n";
            }
        }
        return resultado;
    }

    public double calcularVentasTotales(GestorFeria gestor) {
        double total = 0;
        for (Venta venta : gestor.getVentas()) {
            total += venta.calcularTotal();
        }
        return total;
    }

    public void imprimirResumenEjecutivo(GestorFeria gestor) {
        System.out.println("========== RESUMEN EJECUTIVO ==========");
        System.out.println("Total emprendedores: " + gestor.getEmprendedores().size());
        System.out.println("Total productos: " + gestor.getProductos().size());
        System.out.println("Total ventas: " + gestor.getVentas().size());

        double totalVentas = calcularVentasTotales(gestor);
        System.out.println("Total facturado: $" + totalVentas);

        int emprendedoresStockBajo = 0;
        for (Emprendedor emprendedor : gestor.getEmprendedores()) {
            for (Producto producto : emprendedor.getProductos()) {
                if (producto.tieneStockBajo()) {
                    emprendedoresStockBajo++;
                    break;
                }
            }
        }
        System.out.println("Emprendedores con stock bajo: " + emprendedoresStockBajo);
        System.out.println("=======================================");
    }

    private boolean coincideCategoria(Emprendedor emprendedor, String categoria) {
        return emprendedor.getCategoria() != null
                && categoria != null
                && emprendedor.getCategoria().name().equalsIgnoreCase(categoria);
    }

    private String formatearEmprendedor(Emprendedor emprendedor) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Emprendedor: ").append(emprendedor.getNombre()).append("\n");
        reporte.append("ID: ").append(emprendedor.getIdentificador()).append("\n");
        reporte.append("Contacto: ").append(emprendedor.getTelefono()).append(" | ").append(emprendedor.getEmail()).append("\n");
        reporte.append("Categoria: ").append(emprendedor.getCategoria()).append("\n");
        reporte.append("Productos:\n");

        for (Producto producto : emprendedor.getProductos()) {
            reporte.append("  - ")
                    .append(producto.getNombre())
                    .append(" ($")
                    .append(producto.getPrecio())
                    .append(")\n");
        }

        return reporte.toString();
    }
}
