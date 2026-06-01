package com.feria.utils;

import com.feria.modelos.Emprendedor;
import java.util.Set;
import java.util.regex.Pattern;

public class Validadores {

    // Extracción de constantes y optimización de búsqueda
    private static final Set<String> CATEGORIAS_PERMITIDAS = Set.of("comida", "artesania", "tecnologia", "ropa");

    // Regex básico para mejorar la validación débil del email
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean emailValido(String email) {
        if (email == null) return false;
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean telefonoValido(String telefono) {
        return telefono != null && telefono.length() >= 8;
    }

    public static boolean validarPrecioStock(double precio, int stock) {
        return precio > 0 && stock >= 0;
    }

    public static boolean categoriaPermitida(String categoria) {
        return categoria != null && CATEGORIAS_PERMITIDAS.contains(categoria.toLowerCase());
    }



    public static String validarEmprendedorCompleto(Emprendedor emprendedor) {
        if (emprendedor == null) {
            return "Emprendedor invalido: null";
        }

        StringBuilder resultado = new StringBuilder();
        if (emprendedor.getNombre() == null || emprendedor.getNombre().isBlank()) {
            resultado.append("Nombre invalido. ");
        }
        if (emprendedor.getIdentificador() == null || emprendedor.getIdentificador().isBlank()) {
            resultado.append("Identificador invalido. ");
        }
        if (!telefonoValido(emprendedor.getTelefono())) {
            resultado.append("Telefono invalido. ");
        }
        if (!emailValido(emprendedor.getEmail())) {
            resultado.append("Email invalido. ");
        }
        if (emprendedor.getCategoria() == null) {
            resultado.append("Categoria invalida. ");
        }

        return resultado.length() == 0 ? "Emprendedor valido" : resultado.toString().trim();
    }
}
