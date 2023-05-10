package com.ceiba.etapa.servicio;

import com.ceiba.etapa.excepcion.ExcepcionEtapa;
import com.ceiba.etapa.modelo.entidad.Etapa;
import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;

public class ServicioActualizarEtapa {

    private static final String EL_ETAPA_NO_EXISTE_EN_EL_SISTEMA = "El etapa no existe en el sistema";
    private static final String EL_CODIGO_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El codigo del etapa ya existe en el sistema";

    private final RepositorioEtapa repositorioEtapa;

    public ServicioActualizarEtapa(RepositorioEtapa repositorioEtapa) {
        this.repositorioEtapa = repositorioEtapa;
    }

    public void ejecutar(Etapa etapa) {
        validarExistenciaPreviaEtapa(etapa.getId());
        validarExistenciaPreviaCodigo(etapa.getId(),etapa.getCodigo());
        this.repositorioEtapa.actualizar(etapa);
    }

    private void validarExistenciaPreviaEtapa(Long id) {
        boolean existe = this.repositorioEtapa.existeId(id);
        if (!existe) {
            throw new ExcepcionEtapa(EL_ETAPA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaCodigo(Long id, String codigo) {
        boolean existe = this.repositorioEtapa.existeExcluyendoId(id,codigo);
        if (existe) {
            throw new ExcepcionEtapa(EL_CODIGO_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
