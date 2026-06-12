package com.feria.servicios;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

import com.feria.modelos.*;

class GestorFeriaTddTest {

    @Test
    void buscarPorCategoriaDebeFiltrarEmprendedores() {
        GestorFeria gestor = new GestorFeria();
        Emprendedor e1 = new Emprendedor("Ana", "E001", "3423456789", "ana@mail.com", Categoria.COMIDA);
        Emprendedor e2 = new Emprendedor("Carlos", "E002", "3423987654", "carlos@mail.com", Categoria.ARTESANIA);
        Emprendedor e3 = new Emprendedor("Luis", "E003", "3423111111", "luis@mail.com", Categoria.COMIDA);
        gestor.getEmprendedores().add(e1);
        gestor.getEmprendedores().add(e2);
        gestor.getEmprendedores().add(e3);

        List<Emprendedor> resultado = gestor.buscarPorCategoria("comida");

        assertEquals(2, resultado.size());
        assertTrue(resultado.contains(e1));
        assertTrue(resultado.contains(e3));
        assertFalse(resultado.contains(e2));
    }

    @Test
    void buscarPorCategoriaSinCoincidencias() {
        GestorFeria gestor = new GestorFeria();
        gestor.getEmprendedores().add(new Emprendedor("Ana", "E001", "3423456789", "ana@mail.com", Categoria.COMIDA));

        List<Emprendedor> resultado = gestor.buscarPorCategoria("tecnologia");

        assertTrue(resultado.isEmpty());
    }
}
