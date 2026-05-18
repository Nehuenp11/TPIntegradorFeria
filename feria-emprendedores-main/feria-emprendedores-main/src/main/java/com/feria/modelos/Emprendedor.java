package com.feria.modelos;

import java.util.ArrayList;
import java.util.List;


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

    // SRP: Métodos de negocio separados
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public int calcularValorTotalStock() {
        return productos.stream()
                .mapToInt(p -> (int) (p.getPrecio() * p.getStock()))
                .sum();
    }

    // Encapsulamiento con getters
    public String getNombre() { return nombre; }
    public String getIdentificador() { return identificador; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    public Categoria getCategoria() { return categoria; }
    public List<Producto> getProductos() { return productos; }
}
