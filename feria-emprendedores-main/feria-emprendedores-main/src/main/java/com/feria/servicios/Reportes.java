package com.feria.servicios;

import com.feria.modelos.*;
import com.feria.servicios.reportes.*;

public class Reportes {

    public String generarReportePorCategoria(GestorFeria gestor, String categoria) {
        ReporteBuilder builder = new ReporteCompletoBuilder();
        builder.agregarHeader("REPORTE DE EMPRENDEDORES - CATEGORIA: " + categoria);

        for (Emprendedor emprendedor : gestor.getEmprendedores()) {
            if (coincideCategoria(emprendedor, categoria)) {
                builder.agregarEmprendedor(emprendedor);
                builder.agregarSeparador();
            }
        }

        return builder.construir();
    }

    public String generarReportePorCategoriaAlternativo(GestorFeria gestor, String categoria) {
        ReporteBuilder builder = new ReporteSimpleBuilder();
        builder.agregarHeader("REPORTE CATEGORIA " + categoria);

        for (Emprendedor emprendedor : gestor.getEmprendedores()) {
            if (coincideCategoria(emprendedor, categoria)) {
                builder.agregarEmprendedor(emprendedor);
            }
        }

        return builder.construir();
    }

    public double calcularVentasTotales(GestorFeria gestor) {
        double total = 0;
        for (Venta venta : gestor.getVentas()) {
            total += venta.calcularTotal();
        }
        return total;
    }

    public void imprimirResumenEjecutivo(GestorFeria gestor) {
        ReporteBuilder builder = new ReporteResumenBuilder();
        builder.agregarHeader("RESUMEN EJECUTIVO");
        builder.agregarLinea("Total emprendedores: " + gestor.getEmprendedores().size());
        builder.agregarLinea("Total productos: " + gestor.getProductos().size());
        builder.agregarLinea("Total ventas: " + gestor.getVentas().size());

        double totalVentas = calcularVentasTotales(gestor);
        builder.agregarLinea("Total facturado: $" + totalVentas);

        int emprendedoresStockBajo = 0;
        for (Emprendedor emprendedor : gestor.getEmprendedores()) {
            for (Producto producto : emprendedor.getProductos()) {
                if (producto.tieneStockBajo()) {
                    emprendedoresStockBajo++;
                    break;
                }
            }
        }
        builder.agregarLinea("Emprendedores con stock bajo: " + emprendedoresStockBajo);
        builder.agregarSeparador();

        System.out.println(builder.construir());
    }

    private boolean coincideCategoria(Emprendedor emprendedor, String categoria) {
        return emprendedor.getCategoria() != null
                && categoria != null
                && emprendedor.getCategoria().name().equalsIgnoreCase(categoria);
    }
}
