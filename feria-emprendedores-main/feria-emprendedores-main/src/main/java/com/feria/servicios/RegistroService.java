package com.feria.servicios;

import com.feria.modelos.Emprendedor;
import com.feria.servicios.externos.EmailService;

public class RegistroService {
    private final EmailService emailService;

    public RegistroService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void registrarConNotificacion(Emprendedor e) {
        if (e.getNombre() == null || e.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        emailService.enviar(e.getEmail(), "Bienvenido/a " + e.getNombre(),
                "Tu registro en la feria ha sido exitoso.");
    }
}
