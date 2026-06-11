package com.feria.modelos;

import java.time.LocalDate;

import com.feria.servicios.Descuento;
import com.feria.servicios.DescuentoPorCantidad;
import com.feria.servicios.DescuentoPorMonto;

public class Venta {

    private String idVenta;
    private Emprendedor emprendedor;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;
    private LocalDate fecha;
    private boolean pagoRealizado;

    public Venta(String idVenta, String emprendedor, String producto, int cantidad, double precioUnitario, String fecha) {
        this.idVenta = idVenta;
        this.emprendedor = null;
        this.producto = null;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fecha = LocalDate.parse(fecha);
        this.pagoRealizado = false;
    }

    public Venta(String idVenta, Emprendedor emprendedor, Producto producto, int cantidad, double precioUnitario, LocalDate fecha) {
        this.idVenta = idVenta;
        this.emprendedor = emprendedor;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fecha = fecha;
        this.pagoRealizado = false;
    }

    public double calcularTotal() {
        return cantidad * precioUnitario;
    }

    public double calcularTotalConDescuento() {
        double total = calcularTotal();
        Descuento descCant = new DescuentoPorCantidad();
        Descuento descMonto = new DescuentoPorMonto();
        total = descCant.aplicar(total, cantidad);
        total = descMonto.aplicar(total, cantidad);
        return total;
        
    }

    public void registrarPago() {
        this.pagoRealizado = true;
    }

    // --- Getters ---
    public String getIdVenta() { return idVenta; }
    public Emprendedor getEmprendedor() { return emprendedor; }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
    public LocalDate getFecha() { return fecha; }
    public boolean isPagoRealizado() { return pagoRealizado; }
}

