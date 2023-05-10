package com.ceiba.etapa.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.etapa.comando.ComandoEtapa;
import com.ceiba.etapa.comando.fabrica.FabricaEtapa;
import com.ceiba.etapa.modelo.entidad.Etapa;
import com.ceiba.etapa.servicio.ServicioActualizarEtapa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEtapa implements ManejadorComando<ComandoEtapa> {

    private final FabricaEtapa fabricaEtapa;
    private final ServicioActualizarEtapa servicioActualizarEtapa;

    public ManejadorActualizarEtapa(FabricaEtapa fabricaEtapa, ServicioActualizarEtapa servicioActualizarEtapa) {
        this.fabricaEtapa = fabricaEtapa;
        this.servicioActualizarEtapa = servicioActualizarEtapa;
    }

    public void ejecutar(ComandoEtapa comandoEtapa) {
        Etapa etapa = this.fabricaEtapa.crear(comandoEtapa);
        this.servicioActualizarEtapa.ejecutar(etapa);
    }
}
