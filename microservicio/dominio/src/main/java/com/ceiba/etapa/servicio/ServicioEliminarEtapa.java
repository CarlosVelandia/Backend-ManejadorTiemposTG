package com.ceiba.etapa.servicio;

import com.ceiba.etapa.excepcion.ExcepcionEtapa;
import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;

public class ServicioEliminarEtapa {

    private static final String EL_ETAPA_NO_EXISTE = "El etapa no existe en el sistema";

    private final RepositorioEtapa repositorioEtapa;

    public ServicioEliminarEtapa(RepositorioEtapa repositorioEtapa) {
        this.repositorioEtapa = repositorioEtapa;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaEtapa(id);
        this.repositorioEtapa.eliminar(id);
    }

    private void validarExistenciaPreviaEtapa(Long id) {
        boolean existe = this.repositorioEtapa.existeId(id);
        if (!existe) {
            throw new ExcepcionEtapa(EL_ETAPA_NO_EXISTE);
        }
    }
}
