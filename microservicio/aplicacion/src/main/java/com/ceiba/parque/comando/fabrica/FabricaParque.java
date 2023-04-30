package com.ceiba.parque.comando.fabrica;

import com.ceiba.parque.comando.ComandoParque;
import com.ceiba.parque.modelo.entidad.Parque;
import org.springframework.stereotype.Component;

@Component
public class FabricaParque {

    public Parque crear(ComandoParque comandoParque) {
        return new Parque(
                comandoParque.getId(),
                comandoParque.getNombre(),
                comandoParque.getCodigo(),
                comandoParque.getDireccion(),
                comandoParque.getTelefono()
        );
    }
}
