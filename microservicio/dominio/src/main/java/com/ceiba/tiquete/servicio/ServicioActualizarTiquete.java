package com.ceiba.tiquete.servicio;

import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.tiquete.excepcion.ExcepcionTiquete;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;


public class ServicioActualizarTiquete {


    private static final String EL_TIQUETE_NO_EXISTE = "El tiquete no existe";
    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe";
    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";

    private final RepositorioTiquete repositorioTiquete;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioParque repositorioParque;
    private final ValidadorTiquete validadorTiquete;

    public ServicioActualizarTiquete(RepositorioTiquete repositorioTiquete, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        this.repositorioTiquete = repositorioTiquete;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioParque = repositorioParque;
        this.validadorTiquete = new ValidadorTiquete(this.repositorioTiquete);
    }

    public void ejecutar(Tiquete tiquete) {
        validarExistenciaTiquete(tiquete.getId());
        validarExistenciaUsuario(tiquete.getIdUsuario());
        validarExistenciaParque(tiquete.getIdParque());
        validadorTiquete.maximoTiquetesPersona(tiquete.getFechaCompra(), tiquete.getIdUsuario());
        validadorTiquete.maximoTiquetesParque(tiquete.getFechaCompra(), tiquete.getIdParque());
        this.repositorioTiquete.actualizar(tiquete);
    }

    private void validarExistenciaTiquete(Long id) {
        boolean existe = this.repositorioTiquete.existeId(id);
        if (!existe) {
            throw new ExcepcionTiquete(EL_TIQUETE_NO_EXISTE);
        }
    }

    private void validarExistenciaUsuario(Long idUsuario) {
        boolean existe = this.repositorioUsuario.existeId(idUsuario);
        if (!existe) {
            throw new ExcepcionTiquete(EL_USUARIO_NO_EXISTE);
        }
    }

    private void validarExistenciaParque(Long idParque) {
        boolean existe = this.repositorioParque.existeId(idParque);
        if (!existe) {
            throw new ExcepcionTiquete(EL_PARQUE_NO_EXISTE);
        }
    }

}
