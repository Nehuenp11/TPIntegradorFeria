package com.feria.servicios.validadores;

import com.feria.modelos.Emprendedor;

import java.util.List;

// ValidadorEmprendedor.java
public interface ValidadorEmprendedor {
    List<String> validar(Emprendedor emprendedor);

    void validar();

}

