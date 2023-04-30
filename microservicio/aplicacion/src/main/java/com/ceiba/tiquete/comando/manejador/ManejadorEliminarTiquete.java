package com.ceiba.tiquete.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tiquete.servicio.ServicioEliminarTiquete;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarTiquete implements ManejadorComando<Long> {

    private final ServicioEliminarTiquete servicioEliminarTiquete;

    public ManejadorEliminarTiquete(ServicioEliminarTiquete servicioEliminarTiquete) {
        this.servicioEliminarTiquete = servicioEliminarTiquete;
    }

    public void ejecutar(Long idTiquete) {
        this.servicioEliminarTiquete.ejecutar(idTiquete);
    }
}
