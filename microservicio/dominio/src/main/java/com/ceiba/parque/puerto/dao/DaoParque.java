package com.ceiba.parque.puerto.dao;

import com.ceiba.parque.modelo.dto.DtoParque;

import java.util.List;

public interface DaoParque {
    /**
     * Permite listar parques
     *
     * @return los parques
     */
    List<DtoParque> listar();

}
