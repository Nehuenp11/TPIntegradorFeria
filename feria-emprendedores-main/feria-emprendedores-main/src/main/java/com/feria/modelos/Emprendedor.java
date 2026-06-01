package com.feria.modelos;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class Emprendedor {

    private String nombre;
    private String identificador;
    private String telefono;
    private String email;
    private Categoria categoria;
    private List<Producto> productos;

    public Emprendedor(String nombre, String identificador, String telefono, String email, Categoria categoria) {
        this.nombre = nombre;
        this.identificador = identificador;
        this.telefono = telefono;
        this.email = email;
        this.categoria = categoria;
        this.productos = new ArrayList<>();
    }

    public Emprendedor(String nombre, String identificador, String telefono, String email, String categoria) {
        this(nombre, identificador, telefono, email, parseCategoria(categoria));
    }

    // SRP: Métodos de negocio separados
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public int calcularValorTotalStock() {
        return productos.stream()
                .mapToInt(p -> (int) (p.getPrecio() * p.getStock()))
                .sum();
    }


    public String getNombre() {
        return nombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public String mostrarInfoYValidar() {
        StringJoiner info = new StringJoiner("\n");
        info.add("Emprendedor: " + nombre);
        info.add("ID: " + identificador);
        info.add("Telefono: " + telefono);
        info.add("Email: " + email);
        info.add("Categoria: " + categoria);
        info.add("Productos registrados: " + productos.size());
        return info.toString();
    }

    private static Categoria parseCategoria(String categoria) {
        if (categoria == null) {
            return null;
        }
        try {
            return Categoria.valueOf(categoria.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
