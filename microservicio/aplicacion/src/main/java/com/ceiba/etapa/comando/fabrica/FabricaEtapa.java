package com.ceiba.etapa.comando.fabrica;

import com.ceiba.etapa.comando.ComandoEtapa;
import com.ceiba.etapa.modelo.entidad.Etapa;
import org.springframework.stereotype.Component;

@Component
public class FabricaEtapa {

    public Etapa crear(ComandoEtapa comandoEtapa) {
        return new Etapa(
                comandoEtapa.getId(),
                comandoEtapa.getNombre(),
                comandoEtapa.getCodigo(),
                comandoEtapa.getDireccion(),
                comandoEtapa.getTelefono()
        );
    }
}
