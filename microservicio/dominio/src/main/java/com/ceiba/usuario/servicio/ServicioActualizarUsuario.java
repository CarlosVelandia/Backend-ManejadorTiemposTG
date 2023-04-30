package com.ceiba.usuario.servicio;

import com.ceiba.usuario.excepcion.ExcepcionUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarUsuario {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";
    private static final String LA_CEDULA_YA_EXISTE_EN_EL_SISTEMA = "La cedula ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario.getId());
        validarExistenciaPreviaCedulaExcluyendoId(usuario.getId(),usuario.getCedula());
        this.repositorioUsuario.actualizar(usuario);
    }

    private void validarExistenciaPrevia(Long id) {
        boolean existe = this.repositorioUsuario.existeId(id);
        if (!existe) {
            throw new ExcepcionUsuario(EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaCedulaExcluyendoId(Long id, String cedula) {
        boolean existe = this.repositorioUsuario.existeExcluyendoId(id,cedula);
        if (existe) {
            throw new ExcepcionUsuario(LA_CEDULA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
