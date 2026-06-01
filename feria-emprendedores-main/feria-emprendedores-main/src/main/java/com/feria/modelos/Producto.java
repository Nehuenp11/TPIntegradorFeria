package com.feria.modelos;

public class Producto {

    private String nombre;
    private double precio;
    private int stock;
    private Emprendedor emprendedor; // referencia directa al objeto
    private String categoriaTexto;
    private String emprendedorId;

    public Producto(String nombre, double precio, int stock, Emprendedor emprendedor) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.emprendedor = emprendedor;
        this.categoriaTexto = emprendedor != null && emprendedor.getCategoria() != null
                ? emprendedor.getCategoria().name()
                : null;
        this.emprendedorId = emprendedor != null ? emprendedor.getIdentificador() : null;
    }

    public Producto(String nombre, Double precio, Integer stock, String categoria, String id) {
        this.nombre = nombre;
        this.precio = precio != null ? precio : 0.0;
        this.stock = stock != null ? stock : 0;
        this.categoriaTexto = categoria;
        this.emprendedorId = id;
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
    public String getCategoriaTexto() { return categoriaTexto; }
    public String getEmprendedorId() { return emprendedorId; }

    public void setStock(int stock) { this.stock = stock; }


}
