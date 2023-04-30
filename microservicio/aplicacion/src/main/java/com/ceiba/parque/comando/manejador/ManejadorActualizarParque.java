package com.ceiba.parque.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.parque.comando.ComandoParque;
import com.ceiba.parque.comando.fabrica.FabricaParque;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.servicio.ServicioActualizarParque;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarParque implements ManejadorComando<ComandoParque> {

    private final FabricaParque fabricaParque;
    private final ServicioActualizarParque servicioActualizarParque;

    public ManejadorActualizarParque(FabricaParque fabricaParque, ServicioActualizarParque servicioActualizarParque) {
        this.fabricaParque = fabricaParque;
        this.servicioActualizarParque = servicioActualizarParque;
    }

    public void ejecutar(ComandoParque comandoParque) {
        Parque parque = this.fabricaParque.crear(comandoParque);
        this.servicioActualizarParque.ejecutar(parque);
    }
}
