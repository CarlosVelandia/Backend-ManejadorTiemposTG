package com.ceiba.proceso.consulta;

import com.ceiba.proceso.modelo.dto.DtoProceso;
import com.ceiba.proceso.puerto.dao.DaoProceso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProcesos {

    private final DaoProceso daoProceso;

    public ManejadorListarProcesos(DaoProceso daoProceso) {
        this.daoProceso = daoProceso;
    }

    public List<DtoProceso> ejecutar() {
        return this.daoProceso.listar();
    }
}
