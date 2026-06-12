package com.feria.servicios;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.feria.modelos.Emprendedor;
import com.feria.modelos.Categoria;
import com.feria.servicios.externos.EmailService;

@ExtendWith(MockitoExtension.class)
class RegistroServiceTest {

    @Mock
    private EmailService emailService;

    @Test
    void registrarConNotificacionDebeEnviarEmail() {
        Emprendedor emp = new Emprendedor("Ana", "E001", "3423456789", "ana@mail.com", Categoria.COMIDA);
        RegistroService service = new RegistroService(emailService);

        service.registrarConNotificacion(emp);

        verify(emailService).enviar(eq("ana@mail.com"), anyString(), anyString());
    }

    @Test
    void registrarConNombreVacioLanzaExcepcion() {
        Emprendedor emp = new Emprendedor("", "E001", "3423456789", "ana@mail.com", Categoria.COMIDA);
        RegistroService service = new RegistroService(emailService);

        assertThrows(IllegalArgumentException.class, () -> service.registrarConNotificacion(emp));
        verifyNoInteractions(emailService);
    }
}
