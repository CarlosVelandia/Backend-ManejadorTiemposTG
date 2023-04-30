package com.ceiba.parque.puerto.respositorio;

import com.ceiba.parque.modelo.entidad.Parque;


public interface RepositorioParque {
    /**
     * Permite crear un parque
     *
     * @param parque
     * @return el id generado
     */
    Long crear(Parque parque);

    /**
     * Permite actualizar un parque
     *
     * @param parque
     */
    void actualizar(Parque parque);

    /**
     * Permite eliminar un parque
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un parque con un nombre
     *
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un parque con un nombre excluyendo un id
     *
     * @param codigo
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String codigo);

    /**
     * Permite validar si existe un parque con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeId(Long id);

    /**
     * Permite validar si existe un parque con un codigo
     *
     * @param codigo
     * @return si existe o no
     */
    boolean existeCodigo(String codigo);
}
