package com.ceiba.proceso.servicio;

import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.proceso.excepcion.ExcepcionProceso;
import com.ceiba.proceso.modelo.entidad.Proceso;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;


public class ServicioActualizarProceso {


    private static final String EL_PROCESO_NO_EXISTE = "El proceso no existe";
    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe";
    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";

    private final RepositorioProceso repositorioProceso;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioParque repositorioParque;
    private final ValidadorProceso validadorProceso;

    public ServicioActualizarProceso(RepositorioProceso repositorioProceso, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        this.repositorioProceso = repositorioProceso;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioParque = repositorioParque;
        this.validadorProceso = new ValidadorProceso(this.repositorioProceso);
    }

    public void ejecutar(Proceso proceso) {
        validarExistenciaProceso(proceso.getId());
        validarExistenciaUsuario(proceso.getIdUsuario());
        validarExistenciaParque(proceso.getIdParque());
        validadorProceso.maximoProcesosPersona(proceso.getFechaCompra(), proceso.getIdUsuario());
        validadorProceso.maximoProcesosParque(proceso.getFechaCompra(), proceso.getIdParque());
        this.repositorioProceso.actualizar(proceso);
    }

    private void validarExistenciaProceso(Long id) {
        boolean existe = this.repositorioProceso.existeId(id);
        if (!existe) {
            throw new ExcepcionProceso(EL_PROCESO_NO_EXISTE);
        }
    }

    private void validarExistenciaUsuario(Long idUsuario) {
        boolean existe = this.repositorioUsuario.existeId(idUsuario);
        if (!existe) {
            throw new ExcepcionProceso(EL_USUARIO_NO_EXISTE);
        }
    }

    private void validarExistenciaParque(Long idParque) {
        boolean existe = this.repositorioParque.existeId(idParque);
        if (!existe) {
            throw new ExcepcionProceso(EL_PARQUE_NO_EXISTE);
        }
    }

}
