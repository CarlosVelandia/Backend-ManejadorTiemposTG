package com.ceiba.proceso.puerto.dao;

import com.ceiba.proceso.modelo.dto.DtoProceso;

import java.util.List;

public interface DaoProceso {
    /**
     * Permite listar procesos
     *
     * @return los procesos
     */
    List<DtoProceso> listar();
}
