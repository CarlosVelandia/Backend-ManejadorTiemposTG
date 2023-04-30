package com.ceiba.tiquete.servicio;

import com.ceiba.tiquete.excepcion.ExcepcionTiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;

import java.time.LocalDate;

public class ValidadorTiquete {

    private static final String LIMITE_TIQUETES_POR_PERSONA_ALCANZADO = "Solo se permite un maximo de 5 tiquetes por persona";
    private static final String LIMITE_TIQUETES_POR_PARQUE_ALCANZADO = "Solo se dispone de un maximo de 50 tiquetes por dia";
    private static final int MAXIMO_TIQUETES_POR_PERSONA = 5;
    private static final int MAXIMO_TIQUETES_POR_PARQUE = 15;

    private final RepositorioTiquete repositorioTiquete;

    public ValidadorTiquete(RepositorioTiquete repositorioTiquete) {
        this.repositorioTiquete = repositorioTiquete;
    }

    public void maximoTiquetesParque(LocalDate fechaCompra, Long idParque) {
        int tiquetesParque = this.repositorioTiquete.maximoTiquetesVendidos(fechaCompra, idParque);
        if (tiquetesParque >= MAXIMO_TIQUETES_POR_PARQUE) {
            throw new ExcepcionTiquete(LIMITE_TIQUETES_POR_PARQUE_ALCANZADO);
        }
    }

    public void maximoTiquetesPersona(LocalDate fechaCompra, Long idUsuario) {
        int tiquetesPersona = this.repositorioTiquete.existeTiqueteFechaYCedula(fechaCompra, idUsuario);
        if (tiquetesPersona >= MAXIMO_TIQUETES_POR_PERSONA) {
            throw new ExcepcionTiquete(LIMITE_TIQUETES_POR_PERSONA_ALCANZADO);
        }
    }
}

