package com.feria.servicios;

import com.feria.modelos.*;
import com.feria.servicios.descuentos.DescuentoStrategy;
import com.feria.servicios.validadores.ValidadorEmprendedor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorFeria {

    private final List<Emprendedor> emprendedores;
    private final List<Producto> productos;
    private final List<Venta> ventas;
    private ValidadorEmprendedor validador;

    public GestorFeria() {
        this.emprendedores = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public void registrarEmprendedorConProductos(String nombre, String id, String telefono,
                                                 String email, String categoriaStr,
                                                 List<String> nombresProductos,
                                                 List<Double> precios,
                                                 List<Integer> stocks) {

        Categoria categoria = Categoria.valueOf(categoriaStr.toUpperCase());
        Emprendedor e = new Emprendedor(nombre, id, telefono, email, categoria);

        for (int i = 0; i < nombresProductos.size(); i++) {
            Producto p = new Producto(nombresProductos.get(i), precios.get(i), stocks.get(i), e.getCategoria(), id);
            e.agregarProducto(p);
            productos.add(p);
        }

        emprendedores.add(e);
        System.out.println("Emprendedor registrado con " + nombresProductos.size() + " productos");
    }

    public void registrarVenta(String idVenta, String empId, String prodNombre, int cantidad, double precio, String fecha) {
        Producto productoEncontrado = productos.stream()
                .filter(p -> p.getNombre().equals(prodNombre) && empId.equals(p.getEmprendedorId()))
                .findFirst()
                .orElse(null);

        if (productoEncontrado == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        if (productoEncontrado.getStock() < cantidad) {
            System.out.println("Stock insuficiente");
            return;
        }

        Venta v = new Venta(idVenta, empId, productoEncontrado.getNombre(), cantidad, precio, LocalDate.parse(fecha));
        ventas.add(v);

        productoEncontrado.setStock(productoEncontrado.getStock() - cantidad);

        System.out.println("Venta registrada. Nuevo stock: " + productoEncontrado.getStock());
    }

    public List<Emprendedor> getEmprendedoresConStockBajo() {
        List<Emprendedor> resultado = new ArrayList<>();
        for (Emprendedor e : emprendedores) {
            if (e.getProductos().stream().anyMatch(Producto::tieneStockBajo)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public List<Emprendedor> buscarPorCategoria(String categoria) {
        List<Emprendedor> resultado = new ArrayList<>();
        for (Emprendedor e : emprendedores) {
            if (e.getCategoria() != null
                    && categoria != null
                    && e.getCategoria().name().equalsIgnoreCase(categoria)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public void procesarVentasPendientesYCobrar() {
        double totalRecaudado = 0;
        for (Venta v : ventas) {
            if (!v.isPagoRealizado()) {
                double monto;
                int estrategia = 0;
                monto = v.calcularTotalConDescuento(estrategia);
                totalRecaudado += monto;
                v.registrarPago();
                System.out.println("Cobrada venta " + v.getIdVenta() + " por $" + monto);
            }
        }
        System.out.println("Total recaudado: $" + totalRecaudado);
    }

    // --- Getters ---
    public List<Emprendedor> getEmprendedores() {
        return emprendedores;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Venta> getVentas() {
        return ventas;
    }
}

 