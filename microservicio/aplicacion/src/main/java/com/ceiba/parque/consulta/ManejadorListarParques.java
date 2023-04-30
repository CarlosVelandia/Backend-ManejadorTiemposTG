package com.ceiba.parque.consulta;

import com.ceiba.parque.modelo.dto.DtoParque;
import com.ceiba.parque.puerto.dao.DaoParque;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarParques {

    private final DaoParque daoParque;

    public ManejadorListarParques(DaoParque daoParque) {
        this.daoParque = daoParque;
    }

    public List<DtoParque> ejecutar() {
        return this.daoParque.listar();
    }
}
