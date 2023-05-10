package com.ceiba.etapa.puerto.dao;

import com.ceiba.etapa.modelo.dto.DtoEtapa;

import java.util.List;

public interface DaoEtapa {
    /**
     * Permite listar etapas
     *
     * @return los etapas
     */
    List<DtoEtapa> listar();

}
