package com.feria.modelos;

public class Producto {

    private final String nombre;
    private final double precio;
    private int stock;
    private final Categoria categoria;
    private final String emprendedorId; // referencia por ID, no objeto

    public Producto(String nombre, double precio, int stock, Categoria categoria, String emprendedorId) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.emprendedorId = emprendedorId;
    }

    // --- Métodos de negocio ---
    public double calcularValorTotal() {
        return precio * stock;
    }

    public boolean tieneStockBajo() {
        return stock < 5;
    }

    // --- Getters ---
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getEmprendedorId() {
        return emprendedorId;
    }

    // --- Setters controlados ---
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

}