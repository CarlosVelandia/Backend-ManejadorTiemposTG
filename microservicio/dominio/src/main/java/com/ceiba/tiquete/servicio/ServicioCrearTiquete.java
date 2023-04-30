package com.ceiba.tiquete.servicio;

import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.tiquete.excepcion.ExcepcionTiquete;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;


public class ServicioCrearTiquete {

    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";
    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe";

    private final RepositorioTiquete repositorioTiquete;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioParque repositorioParque;
    private final ValidadorTiquete validadorTiquete;

    public ServicioCrearTiquete(RepositorioTiquete repositorioTiquete, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        this.repositorioTiquete = repositorioTiquete;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioParque = repositorioParque;
        this.validadorTiquete = new ValidadorTiquete(this.repositorioTiquete);
    }

    public Long ejecutar(Tiquete tiquete) {
        validarExistenciaUsuario(tiquete.getIdUsuario());
        validarExistenciaParque(tiquete.getIdParque());
        validadorTiquete.maximoTiquetesPersona(tiquete.getFechaCompra(), tiquete.getIdUsuario());
        validadorTiquete.maximoTiquetesParque(tiquete.getFechaCompra(), tiquete.getIdParque());
        return this.repositorioTiquete.crear(tiquete);
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
