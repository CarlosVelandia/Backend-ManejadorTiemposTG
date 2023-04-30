package com.ceiba.tiquete.servicio;

import com.ceiba.tiquete.excepcion.ExcepcionTiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;

public class ServicioEliminarTiquete {

    private static final String EL_TIQUETE_NO_EXISTE = "El tiquete no existe en el sistema";

    private final RepositorioTiquete repositorioTiquete;

    public ServicioEliminarTiquete(RepositorioTiquete repositorioTiquete) {
        this.repositorioTiquete = repositorioTiquete;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaTiquete(id);
        this.repositorioTiquete.eliminar(id);
    }

    private void validarExistenciaPreviaTiquete(Long id) {
        boolean existe = this.repositorioTiquete.existeId(id);
        if (!existe) {
            throw new ExcepcionTiquete(EL_TIQUETE_NO_EXISTE);
        }
    }
}
