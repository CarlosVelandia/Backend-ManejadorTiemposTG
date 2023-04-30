package com.ceiba.usuario.servicio;

import com.ceiba.usuario.excepcion.ExcepcionUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private static final String EL_USUARIO_NO_EXISTE = "El usuario no existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
        validarExistenciaPreviaUsuario(id);
        this.repositorioUsuario.eliminar(id);
    }

    private void validarExistenciaPreviaUsuario(Long id) {
        boolean existe = this.repositorioUsuario.existeId(id);
        if (!existe) {
            throw new ExcepcionUsuario(EL_USUARIO_NO_EXISTE);
        }
    }
}
