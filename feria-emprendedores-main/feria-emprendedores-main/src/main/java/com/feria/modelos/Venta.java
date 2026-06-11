package com.feria.modelos;

import java.time.LocalDate;

public class Venta {

    private final String idVenta;
    private final String emprendedorId;   // referencia por ID, no objeto
    private final String productoId;      // referencia por ID, no objeto
    private final int cantidad;
    private final double precioUnitario;
    private final LocalDate fecha;
    private boolean pagoRealizado;

    public Venta(String idVenta, String emprendedorId, String productoId, int cantidad, double precioUnitario, LocalDate fecha) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        if (precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio unitario debe ser mayor a 0");
        }
        this.idVenta = idVenta;
        this.emprendedorId = emprendedorId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fecha = fecha;
        this.pagoRealizado = false;
    }

    // --- Métodos de negocio ---
    public double calcularTotal() {
        return cantidad * precioUnitario;
    }

    public double calcularTotalConDescuento(int estrategia) {
        return estrategia;
    }

    public void registrarPago() {
        this.pagoRealizado = true;
    }

    // --- Getters ---
    public String getIdVenta() {
        return idVenta;
    }

    public String getEmprendedorId() {
        return emprendedorId;
    }

    public String getProductoId() {
        return productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isPagoRealizado() {
        return pagoRealizado;
    }
}

