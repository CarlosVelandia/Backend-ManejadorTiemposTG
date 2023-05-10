package com.ceiba.etapa.puerto.respositorio;

import com.ceiba.etapa.modelo.entidad.Etapa;


public interface RepositorioEtapa {
    /**
     * Permite crear un etapa
     *
     * @param etapa
     * @return el id generado
     */
    Long crear(Etapa etapa);

    /**
     * Permite actualizar un etapa
     *
     * @param etapa
     */
    void actualizar(Etapa etapa);

    /**
     * Permite eliminar un etapa
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un etapa con un nombre
     *
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un etapa con un nombre excluyendo un id
     *
     * @param codigo
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String codigo);

    /**
     * Permite validar si existe un etapa con un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeId(Long id);

    /**
     * Permite validar si existe un etapa con un codigo
     *
     * @param codigo
     * @return si existe o no
     */
    boolean existeCodigo(String codigo);
}
