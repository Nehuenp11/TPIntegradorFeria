package com.feria.servicios;

import com.feria.modelos.*;

public class Reportes {

    public String generarReportePorCategoria(GestorFeria gestor, String categoria) {
        String reporte = "=== REPORTE DE EMPRENDEDORES - CATEGORIA: " + categoria + " ===\n";

        for (Emprendedor emprendedor : gestor.emprendedores) {
            if (coincideCategoria(emprendedor, categoria)) {
                reporte += formatearEmprendedor(emprendedor);
                reporte += "---\n";
            }
        }

        return reporte;
    }

    public String generarReportePorCategoriaAlternativo(GestorFeria gestor, String categoria) {
        String resultado = "REPORTE CATEGORIA " + categoria + "\n";
        for (Emprendedor emprendedor : gestor.emprendedores) {
            if (coincideCategoria(emprendedor, categoria)) {
                resultado += emprendedor.getNombre() + "\n";
            }
        }
        return resultado;
    }

    public double calcularVentasTotales(GestorFeria gestor) {
        double total = 0;
        for (Venta venta : gestor.ventas) {
            total += venta.calcularTotal();
        }
        return total;
    }

    public void imprimirResumenEjecutivo(GestorFeria gestor) {
        System.out.println("========== RESUMEN EJECUTIVO ==========");
        System.out.println("Total emprendedores: " + gestor.emprendedores.size());
        System.out.println("Total productos: " + gestor.productos.size());
        System.out.println("Total ventas: " + gestor.ventas.size());

        double totalVentas = calcularVentasTotales(gestor);
        System.out.println("Total facturado: $" + totalVentas);

        int emprendedoresStockBajo = 0;
        for (Emprendedor emprendedor : gestor.emprendedores) {
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
        reporte.append("Nombre: ").append(emprendedor.getNombre()).append("\n");
        reporte.append("ID: ").append(emprendedor.getIdentificador()).append("\n");
        reporte.append("Telefono: ").append(emprendedor.getTelefono()).append("\n");
        reporte.append("Email: ").append(emprendedor.getEmail()).append("\n");
        reporte.append("Categoria: ").append(emprendedor.getCategoria()).append("\n");
        reporte.append("Productos:\n");

        for (Producto producto : emprendedor.getProductos()) {
            reporte.append("- ")
                    .append(producto.getNombre())
                    .append(" | Precio: $")
                    .append(producto.getPrecio())
                    .append(" | Stock: ")
                    .append(producto.getStock())
                    .append("\n");
        }

        return reporte.toString();
    }
}
