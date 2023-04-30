package com.ceiba.tiquete.consulta;

import com.ceiba.tiquete.modelo.dto.DtoTiquete;
import com.ceiba.tiquete.puerto.dao.DaoTiquete;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarTiquetes {

    private final DaoTiquete daoTiquete;

    public ManejadorListarTiquetes(DaoTiquete daoTiquete) {
        this.daoTiquete = daoTiquete;
    }

    public List<DtoTiquete> ejecutar() {
        return this.daoTiquete.listar();
    }
}
