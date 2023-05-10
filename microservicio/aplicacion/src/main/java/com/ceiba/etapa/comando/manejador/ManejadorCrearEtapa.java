package com.ceiba.etapa.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.etapa.comando.ComandoEtapa;
import com.ceiba.etapa.comando.fabrica.FabricaEtapa;
import com.ceiba.etapa.modelo.entidad.Etapa;
import com.ceiba.etapa.servicio.ServicioCrearEtapa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEtapa implements ManejadorComandoRespuesta<ComandoEtapa, ComandoRespuesta<Long>> {

    private final FabricaEtapa fabricaEtapa;
    private final ServicioCrearEtapa servicioCrearEtapa;

    public ManejadorCrearEtapa(FabricaEtapa fabricaEtapa, ServicioCrearEtapa servicioCrearEtapa) {
        this.fabricaEtapa = fabricaEtapa;
        this.servicioCrearEtapa = servicioCrearEtapa;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEtapa comandoEtapa) {
        Etapa etapa = this.fabricaEtapa.crear(comandoEtapa);
        return new ComandoRespuesta<>(this.servicioCrearEtapa.ejecutar(etapa));
    }
}
