package com.ceiba.tiquete.comando.fabrica;

import com.ceiba.tiquete.comando.ComandoTiquete;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import org.springframework.stereotype.Component;

@Component
public class FabricaTiquete {

    public Tiquete crear(ComandoTiquete comandoTiquete) {
        return new Tiquete(
                comandoTiquete.getId(),
                comandoTiquete.getIdUsuario(),
                comandoTiquete.getIdParque(),
                comandoTiquete.getFechaCompra(),
                comandoTiquete.getValor()
        );
    }
}
