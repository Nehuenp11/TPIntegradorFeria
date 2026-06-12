package com.feria.servicios.validadores;

import com.feria.modelos.Emprendedor;

import java.util.ArrayList;
import java.util.List;

public class Validadores implements ValidadorEmprendedor {

    @Override
    public List<String> validar(Emprendedor e) {
        List<String> errores = new ArrayList<>();
        if (e.getNombre() == null || e.getNombre().length() < 2) {
            errores.add("Nombre demasiado corto");
        }
        if (e.getEmail() == null || !e.getEmail().contains("@")) {
            errores.add("Email inválido");
        }
        if (e.getCategoria() == null) {
            errores.add("Categoría desconocida");
        }
        return errores;
    }

    @Override
    public void validar() {
    }

    public static boolean emailValido(String email) {
        return email != null && email.contains("@");
    }
}
