package com.ceiba.proceso.comando.fabrica;

import com.ceiba.proceso.comando.ComandoProceso;
import com.ceiba.proceso.modelo.entidad.Proceso;
import org.springframework.stereotype.Component;

@Component
public class FabricaProceso {

    public Proceso crear(ComandoProceso comandoProceso) {
        return new Proceso(
                comandoProceso.getId(),
                comandoProceso.getIdUsuario(),
                comandoProceso.getIdParque(),
                comandoProceso.getFechaCompra(),
                comandoProceso.getValor()
        );
    }
}
