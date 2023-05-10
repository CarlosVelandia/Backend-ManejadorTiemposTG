package com.ceiba.proceso.puerto.repositorio;

import com.ceiba.proceso.modelo.entidad.Proceso;

import java.time.LocalDate;

public interface RepositorioProceso {
    /**
     * Permite crear un proceso
     *
     * @param proceso
     * @return el id generado
     */
    Long crear(Proceso proceso);

    /**
     * Permite actualizar un proceso
     *
     * @param proceso
     */
    void actualizar(Proceso proceso);

    /**
     * Permite eliminar un proceso
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un proceso con un usuario
     *
     * @param fechaCompra
     * @param idUsuario
     * @return si existe o no
     */
    int existeProcesoFechaYCedula(LocalDate fechaCompra, Long idUsuario);

    /**
     * Permite validar si se vendieron todos los procesos del dia
     *
     * @param fechaCompra
     * @param idEtapa
     * @return si se vendieron o no
     */
    int maximoProcesosVendidos(LocalDate fechaCompra, Long idEtapa);

    /**
     * Permite validar si existe un proceso con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeId(Long id);
}
