package com.ceiba.proceso.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.proceso.servicio.ServicioEliminarProceso;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProceso implements ManejadorComando<Long> {

    private final ServicioEliminarProceso servicioEliminarProceso;

    public ManejadorEliminarProceso(ServicioEliminarProceso servicioEliminarProceso) {
        this.servicioEliminarProceso = servicioEliminarProceso;
    }

    public void ejecutar(Long idProceso) {
        this.servicioEliminarProceso.ejecutar(idProceso);
    }
}
