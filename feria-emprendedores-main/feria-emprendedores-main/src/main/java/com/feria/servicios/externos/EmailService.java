package com.feria.servicios.externos;

public interface EmailService {
    void enviar(String destino, String asunto, String cuerpo);
}
