package com.ceiba.proceso.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.proceso.comando.ComandoProceso;
import com.ceiba.proceso.comando.fabrica.FabricaProceso;
import com.ceiba.proceso.modelo.entidad.Proceso;
import com.ceiba.proceso.servicio.ServicioActualizarProceso;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProceso implements ManejadorComando<ComandoProceso> {

    private final FabricaProceso fabricaProceso;
    private final ServicioActualizarProceso servicioActualizarProceso;

    public ManejadorActualizarProceso(FabricaProceso fabricaProceso, ServicioActualizarProceso servicioActualizarProceso) {
        this.fabricaProceso = fabricaProceso;
        this.servicioActualizarProceso = servicioActualizarProceso;
    }

    public void ejecutar(ComandoProceso comandoProceso) {
        Proceso proceso = this.fabricaProceso.crear(comandoProceso);
        this.servicioActualizarProceso.ejecutar(proceso);
    }
}
