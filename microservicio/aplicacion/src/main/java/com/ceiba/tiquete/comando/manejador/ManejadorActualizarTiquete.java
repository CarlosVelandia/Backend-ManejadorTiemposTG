package com.ceiba.tiquete.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.tiquete.comando.ComandoTiquete;
import com.ceiba.tiquete.comando.fabrica.FabricaTiquete;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.servicio.ServicioActualizarTiquete;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarTiquete implements ManejadorComando<ComandoTiquete> {

    private final FabricaTiquete fabricaTiquete;
    private final ServicioActualizarTiquete servicioActualizarTiquete;

    public ManejadorActualizarTiquete(FabricaTiquete fabricaTiquete, ServicioActualizarTiquete servicioActualizarTiquete) {
        this.fabricaTiquete = fabricaTiquete;
        this.servicioActualizarTiquete = servicioActualizarTiquete;
    }

    public void ejecutar(ComandoTiquete comandoTiquete) {
        Tiquete tiquete = this.fabricaTiquete.crear(comandoTiquete);
        this.servicioActualizarTiquete.ejecutar(tiquete);
    }
}
