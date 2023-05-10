package com.ceiba.etapa.consulta;

import com.ceiba.etapa.modelo.dto.DtoEtapa;
import com.ceiba.etapa.puerto.dao.DaoEtapa;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEtapas {

    private final DaoEtapa daoEtapa;

    public ManejadorListarEtapas(DaoEtapa daoEtapa) {
        this.daoEtapa = daoEtapa;
    }

    public List<DtoEtapa> ejecutar() {
        return this.daoEtapa.listar();
    }
}
