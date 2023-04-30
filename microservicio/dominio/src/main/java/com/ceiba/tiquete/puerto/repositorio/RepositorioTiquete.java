package com.ceiba.tiquete.puerto.repositorio;

import com.ceiba.tiquete.modelo.entidad.Tiquete;

import java.time.LocalDate;

public interface RepositorioTiquete {
    /**
     * Permite crear un tiquete
     *
     * @param tiquete
     * @return el id generado
     */
    Long crear(Tiquete tiquete);

    /**
     * Permite actualizar un tiquete
     *
     * @param tiquete
     */
    void actualizar(Tiquete tiquete);

    /**
     * Permite eliminar un tiquete
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un tiquete con un usuario
     *
     * @param fechaCompra
     * @param idUsuario
     * @return si existe o no
     */
    int existeTiqueteFechaYCedula(LocalDate fechaCompra, Long idUsuario);

    /**
     * Permite validar si se vendieron todos los tiquetes del dia
     *
     * @param fechaCompra
     * @param idParque
     * @return si se vendieron o no
     */
    int maximoTiquetesVendidos(LocalDate fechaCompra, Long idParque);

    /**
     * Permite validar si existe un tiquete con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeId(Long id);
}
