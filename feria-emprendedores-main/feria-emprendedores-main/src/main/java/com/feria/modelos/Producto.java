package com.feria.modelos;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private Emprendedor emprendedor; // referencia directa al objeto

    public Producto(String nombre, double precio, int stock, Emprendedor emprendedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.emprendedor = emprendedor;
    }

    // --- Métodos de negocio ---
    public double calcularValorTotal() {
        return precio * stock;
    }

    public boolean tieneStockBajo() {
        return stock < 5;
    }

    // --- Getters y Setters ---
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public Emprendedor getEmprendedor() { return emprendedor; }

    public void setStock(int stock) { this.stock = stock; }
}
