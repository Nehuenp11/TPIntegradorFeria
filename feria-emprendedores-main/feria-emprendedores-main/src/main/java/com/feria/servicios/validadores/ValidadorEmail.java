package com.feria.servicios.validadores;

import com.feria.modelos.Emprendedor;
import java.util.ArrayList;
import java.util.List;

public abstract class ValidadorEmail implements ValidadorEmprendedor {
    @Override
    public List<String> validar(Emprendedor e) {
        List<String> errores = new ArrayList<>();
        if (e.getEmail() == null || !e.getEmail().contains("@")) {
            errores.add("⚠️ Email inválido");
        }
        return errores;
    }
}
