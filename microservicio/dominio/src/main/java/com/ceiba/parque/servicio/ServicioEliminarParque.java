package com.ceiba.parque.servicio;

import com.ceiba.parque.excepcion.ExcepcionParque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioEliminarParque {

    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioEliminarParque(RepositorioParque repositorioParque) {
        this.repositorioParque = repositorioParque;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaParque(id);
        this.repositorioParque.eliminar(id);
    }

    private void validarExistenciaPreviaParque(Long id) {
        boolean existe = this.repositorioParque.existeId(id);
        if (!existe) {
            throw new ExcepcionParque(EL_PARQUE_NO_EXISTE);
        }
    }
}
