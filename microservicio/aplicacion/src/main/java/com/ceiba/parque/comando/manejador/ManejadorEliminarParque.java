package com.ceiba.parque.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.parque.servicio.ServicioEliminarParque;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarParque implements ManejadorComando<Long> {

    private final ServicioEliminarParque servicioEliminarParque;

    public ManejadorEliminarParque(ServicioEliminarParque servicioEliminarParque) {
        this.servicioEliminarParque = servicioEliminarParque;
    }

    public void ejecutar(Long idParque) {
        this.servicioEliminarParque.ejecutar(idParque);
    }
}
