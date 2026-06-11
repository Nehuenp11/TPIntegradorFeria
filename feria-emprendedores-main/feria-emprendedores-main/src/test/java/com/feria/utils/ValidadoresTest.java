package com.feria.utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ValidadoresTest {

    @Test
    void emailValidoConFormatoCorrecto() {
        assertTrue(Validadores.emailValido("test@mail.com"));
    }

    @Test
    void emailValidoConNull() {
        assertFalse(Validadores.emailValido(null));
    }

    @Test
    void emailValidoSinArroba() {
        assertFalse(Validadores.emailValido("testmail.com"));
    }
}
