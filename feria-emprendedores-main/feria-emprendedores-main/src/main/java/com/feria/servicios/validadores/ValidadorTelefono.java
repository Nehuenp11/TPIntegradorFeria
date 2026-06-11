package com.feria.servicios.validadores;

import com.feria.modelos.Emprendedor;
import java.util.ArrayList;
import java.util.List;

public class ValidadorTelefono implements ValidadorEmprendedor {
    @Override
    public List<String> validar(Emprendedor e) {
        List<String> errores = new ArrayList<>();
        if (e.getTelefono() == null || e.getTelefono().length() < 8) {
            errores.add("⚠️ Teléfono inválido");
        }
        return errores;
    }

    @Override
    public void validar() {

    }
}
