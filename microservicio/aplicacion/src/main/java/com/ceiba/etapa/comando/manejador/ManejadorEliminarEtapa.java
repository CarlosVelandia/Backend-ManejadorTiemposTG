package com.ceiba.etapa.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.etapa.servicio.ServicioEliminarEtapa;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEtapa implements ManejadorComando<Long> {

    private final ServicioEliminarEtapa servicioEliminarEtapa;

    public ManejadorEliminarEtapa(ServicioEliminarEtapa servicioEliminarEtapa) {
        this.servicioEliminarEtapa = servicioEliminarEtapa;
    }

    public void ejecutar(Long idEtapa) {
        this.servicioEliminarEtapa.ejecutar(idEtapa);
    }
}
