package com.ceiba.proceso.servicio;

import com.ceiba.proceso.excepcion.ExcepcionProceso;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;

public class ServicioEliminarProceso {

    private static final String EL_PROCESO_NO_EXISTE = "El proceso no existe en el sistema";

    private final RepositorioProceso repositorioProceso;

    public ServicioEliminarProceso(RepositorioProceso repositorioProceso) {
        this.repositorioProceso = repositorioProceso;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaProceso(id);
        this.repositorioProceso.eliminar(id);
    }

    private void validarExistenciaPreviaProceso(Long id) {
        boolean existe = this.repositorioProceso.existeId(id);
        if (!existe) {
            throw new ExcepcionProceso(EL_PROCESO_NO_EXISTE);
        }
    }
}
