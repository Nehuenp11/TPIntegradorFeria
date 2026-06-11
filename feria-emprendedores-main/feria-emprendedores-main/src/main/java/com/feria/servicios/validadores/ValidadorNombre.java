package com.feria.servicios.validadores;

import com.feria.modelos.Emprendedor;
import java.util.ArrayList;
import java.util.List;

public abstract class ValidadorNombre implements ValidadorEmprendedor {
    @Override
    public List<String> validar(Emprendedor e) {
        List<String> errores = new ArrayList<>();
        if (e.getNombre() == null || e.getNombre().length() < 2) {
            errores.add("⚠️ Nombre demasiado corto");
        }
        return errores;
    }

    @Override
    public void validar() {

    }
}
