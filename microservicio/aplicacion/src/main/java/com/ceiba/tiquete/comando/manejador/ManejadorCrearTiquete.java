package com.ceiba.tiquete.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.tiquete.comando.ComandoTiquete;
import com.ceiba.tiquete.comando.fabrica.FabricaTiquete;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.servicio.ServicioCrearTiquete;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearTiquete implements ManejadorComandoRespuesta<ComandoTiquete, ComandoRespuesta<Long>> {

    private final FabricaTiquete fabricaTiquete;
    private final ServicioCrearTiquete servicioCrearTiquete;

    public ManejadorCrearTiquete(FabricaTiquete fabricaTiquete, ServicioCrearTiquete servicioCrearTiquete) {
        this.fabricaTiquete = fabricaTiquete;
        this.servicioCrearTiquete = servicioCrearTiquete;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTiquete comandoTiquete) {
        Tiquete tiquete = this.fabricaTiquete.crear(comandoTiquete);
        return new ComandoRespuesta<>(this.servicioCrearTiquete.ejecutar(tiquete));
    }
}

