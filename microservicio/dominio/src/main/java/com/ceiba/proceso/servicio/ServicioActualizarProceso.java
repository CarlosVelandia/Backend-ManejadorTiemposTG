package com.ceiba.proceso.servicio;

import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;
import com.ceiba.proceso.excepcion.ExcepcionProceso;
import com.ceiba.proceso.modelo.entidad.Proceso;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;


public class ServicioActualizarProceso {


    private static final String EL_PROCESO_NO_EXISTE = "El proceso no existe";
    private static final String EL_ETAPA_NO_EXISTE = "El etapa no existe";
    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";

    private final RepositorioProceso repositorioProceso;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioEtapa repositorioEtapa;
    private final ValidadorProceso validadorProceso;

    public ServicioActualizarProceso(RepositorioProceso repositorioProceso, RepositorioUsuario repositorioUsuario, RepositorioEtapa repositorioEtapa) {
        this.repositorioProceso = repositorioProceso;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioEtapa = repositorioEtapa;
        this.validadorProceso = new ValidadorProceso(this.repositorioProceso);
    }

    public void ejecutar(Proceso proceso) {
        validarExistenciaProceso(proceso.getId());
        validarExistenciaUsuario(proceso.getIdUsuario());
        validarExistenciaEtapa(proceso.getIdEtapa());
        validadorProceso.maximoProcesosPersona(proceso.getFechaCompra(), proceso.getIdUsuario());
        validadorProceso.maximoProcesosEtapa(proceso.getFechaCompra(), proceso.getIdEtapa());
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

    private void validarExistenciaEtapa(Long idEtapa) {
        boolean existe = this.repositorioEtapa.existeId(idEtapa);
        if (!existe) {
            throw new ExcepcionProceso(EL_ETAPA_NO_EXISTE);
        }
    }

}
