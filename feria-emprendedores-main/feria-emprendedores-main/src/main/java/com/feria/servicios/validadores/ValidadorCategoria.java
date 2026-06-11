package com.feria.servicios.validadores;

import com.feria.modelos.Emprendedor;
import java.util.ArrayList;
import java.util.List;

public class ValidadorCategoria implements ValidadorEmprendedor {
    @Override
    public List<String> validar(Emprendedor e) {
        List<String> errores = new ArrayList<>();
        if (e.getCategoria() == null) {
            errores.add("⚠️ Categoría desconocida");
        }
        return errores;
    }

    @Override
    public void validar() {

    }
}
