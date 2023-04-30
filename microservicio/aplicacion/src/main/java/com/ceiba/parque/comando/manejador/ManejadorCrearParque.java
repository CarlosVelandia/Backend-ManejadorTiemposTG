package com.ceiba.parque.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.parque.comando.ComandoParque;
import com.ceiba.parque.comando.fabrica.FabricaParque;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.servicio.ServicioCrearParque;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearParque implements ManejadorComandoRespuesta<ComandoParque, ComandoRespuesta<Long>> {

    private final FabricaParque fabricaParque;
    private final ServicioCrearParque servicioCrearParque;

    public ManejadorCrearParque(FabricaParque fabricaParque, ServicioCrearParque servicioCrearParque) {
        this.fabricaParque = fabricaParque;
        this.servicioCrearParque = servicioCrearParque;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoParque comandoParque) {
        Parque parque = this.fabricaParque.crear(comandoParque);
        return new ComandoRespuesta<>(this.servicioCrearParque.ejecutar(parque));
    }
}
