package com.feria;

import com.feria.modelos.*;
import com.feria.servicios.*;
import com.feria.servicios.validadores.*;
import com.feria.servicios.validadores.Validadores;
import com.feria.utils.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GestorFeria gestor = new GestorFeria();
        Reportes reportes = new Reportes();
        ValidadorEmprendedor validador = new Validadores();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del emprendedor: ");
        String nombreEmprendedor = scanner.nextLine();

        gestor.registrarEmprendedorConProductos(
                nombreEmprendedor, "E001", "3423456789", "ana@gmail.com", "comida",
                Arrays.asList("Empanadas", "Tortas", "Alfajores"),
                Arrays.asList(500.0, 1500.0, 300.0),
                Arrays.asList(50, 10, 100)
        );

        // Crear otro emprendedor con productos
        Emprendedor emp2 = new Emprendedor("Carlos", "E002", "3423987654", "carlos@hotmail.com", Categoria.ARTESANIA);
        Producto p1 = new Producto("Collar", 2000.0, 5, Categoria.ARTESANIA, "E002");
        Producto p2 = new Producto("Pulsera", 800.0, 20, Categoria.ARTESANIA, "E002");
        emp2.agregarProducto(p1);
        emp2.agregarProducto(p2);
        gestor.getEmprendedores().add(emp2);
        gestor.getProductos().add(p1);
        gestor.getProductos().add(p2);

        // Registrar ventas
        gestor.registrarVenta("V001", "E001", "Empanadas", 10, 500.0, "2026-05-12");
        gestor.registrarVenta("V002", "E002", "Collar", 1, 2000.0, "2026-05-12");

        // Reportes
        System.out.println(reportes.generarReportePorCategoria(gestor, "comida"));
        gestor.procesarVentasPendientesYCobrar();
        reportes.imprimirResumenEjecutivo(gestor);

        // Validación con servicio
        System.out.println("Emprendedor " + nombreEmprendedor + " válido? "
                + validador.validar(gestor.getEmprendedores().get(0)));

        // Formateo con utils
        System.out.println(EmprendedorFormatter.formatear(gestor.getEmprendedores().get(0)));

        scanner.close();
    }
}
