package com.ceiba.tiquete.puerto.dao;

import com.ceiba.tiquete.modelo.dto.DtoTiquete;

import java.util.List;

public interface DaoTiquete {
    /**
     * Permite listar tiquetes
     *
     * @return los tiquetes
     */
    List<DtoTiquete> listar();
}
