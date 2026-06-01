package com.feria;

import com.feria.modelos.*;
import com.feria.servicios.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Inicialización del sistema
        GestorFeria gestor = new GestorFeria();
        Reportes reportes = new Reportes();

        // Carga de datos unificada y respetando la encapsulación
        inicializarDatosPrueba(gestor);

        // Registro de operaciones de negocio claras
        gestor.registrarVenta("V001", "E001", "Empanadas", 10, 500.0, "2026-05-12");
        gestor.registrarVenta("V002", "E002", "Collar", 1, 2000.0, "2026-05-12");

        // Ejecución de procesos y reportes
        System.out.println(reportes.generarReportePorCategoria(gestor, "comida"));
        
        gestor.procesarVentasPendientesYCobrar();
        
        reportes.imprimirResumenEjecutivo(gestor);

        // Se elimina la Ley de Deméter delegando la consulta al gestor
        System.out.println(gestor.obtenerEstadoValidacionEmprendedor("E001"));
    }

    private static void inicializarDatosPrueba(GestorFeria gestor) {
        // Ana: Se agregan productos compuestos en lugar de listas paralelas
        Emprendedor emp1 = new Emprendedor("Ana", "E001", "3423456789", "ana@gmail.com", "comida");
        emp1.agregarProducto(new Producto("Empanadas", 500.0, 50, "comida", "E001"));
        emp1.agregarProducto(new Producto("Tortas", 1500.0, 10, "comida", "E001"));
        emp1.agregarProducto(new Producto("Alfajores", 300.0, 100, "comida", "E001"));
        gestor.registrarEmprendedor(emp1); // El gestor expone un método, no su lista interna

        // Carlos: Sigue exactamente la misma estructura uniforme
        Emprendedor emp2 = new Emprendedor("Carlos", "E002", "3423987654", "carlos@hotmail.com", "artesania");
        emp2.agregarProducto(new Producto("Collar", 2000.0, 5, "artesania", "E002"));
        emp2.agregarProducto(new Producto("Pulsera", 800.0, 20, "artesania", "E002"));
        gestor.registrarEmprendedor(emp2);
    }
}
