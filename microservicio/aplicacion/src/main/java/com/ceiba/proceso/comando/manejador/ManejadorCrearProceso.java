package com.ceiba.proceso.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.proceso.comando.ComandoProceso;
import com.ceiba.proceso.comando.fabrica.FabricaProceso;
import com.ceiba.proceso.modelo.entidad.Proceso;
import com.ceiba.proceso.servicio.ServicioCrearProceso;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProceso implements ManejadorComandoRespuesta<ComandoProceso, ComandoRespuesta<Long>> {

    private final FabricaProceso fabricaProceso;
    private final ServicioCrearProceso servicioCrearProceso;

    public ManejadorCrearProceso(FabricaProceso fabricaProceso, ServicioCrearProceso servicioCrearProceso) {
        this.fabricaProceso = fabricaProceso;
        this.servicioCrearProceso = servicioCrearProceso;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoProceso comandoProceso) {
        Proceso proceso = this.fabricaProceso.crear(comandoProceso);
        return new ComandoRespuesta<>(this.servicioCrearProceso.ejecutar(proceso));
    }
}

