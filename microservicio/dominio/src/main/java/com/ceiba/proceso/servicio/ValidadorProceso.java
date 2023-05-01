package com.ceiba.proceso.servicio;

import com.ceiba.proceso.excepcion.ExcepcionProceso;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;

import java.time.LocalDate;

public class ValidadorProceso {

    private static final String LIMITE_PROCESOS_POR_PERSONA_ALCANZADO = "Solo se permite un maximo de 5 procesos por persona";
    private static final String LIMITE_PROCESOS_POR_PARQUE_ALCANZADO = "Solo se dispone de un maximo de 50 procesos por dia";
    private static final int MAXIMO_PROCESOS_POR_PERSONA = 5;
    private static final int MAXIMO_PROCESOS_POR_PARQUE = 15;

    private final RepositorioProceso repositorioProceso;

    public ValidadorProceso(RepositorioProceso repositorioProceso) {
        this.repositorioProceso = repositorioProceso;
    }

    public void maximoProcesosParque(LocalDate fechaCompra, Long idParque) {
        int procesosParque = this.repositorioProceso.maximoProcesosVendidos(fechaCompra, idParque);
        if (procesosParque >= MAXIMO_PROCESOS_POR_PARQUE) {
            throw new ExcepcionProceso(LIMITE_PROCESOS_POR_PARQUE_ALCANZADO);
        }
    }

    public void maximoProcesosPersona(LocalDate fechaCompra, Long idUsuario) {
        int procesosPersona = this.repositorioProceso.existeProcesoFechaYCedula(fechaCompra, idUsuario);
        if (procesosPersona >= MAXIMO_PROCESOS_POR_PERSONA) {
            throw new ExcepcionProceso(LIMITE_PROCESOS_POR_PERSONA_ALCANZADO);
        }
    }
}

