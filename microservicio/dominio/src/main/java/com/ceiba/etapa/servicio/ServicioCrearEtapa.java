package com.ceiba.etapa.servicio;

import com.ceiba.etapa.excepcion.ExcepcionEtapa;
import com.ceiba.etapa.modelo.entidad.Etapa;
import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;

public class ServicioCrearEtapa {

    private static final String EL_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El etapa ya existe en el sistema";
    private static final String EL_NOMBRE_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El nombre del etapa ya existe en el sistema";
    private static final String EL_CODIGO_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El codigo del etapa ya existe en el sistema";

    private final RepositorioEtapa repositorioEtapa;

    public ServicioCrearEtapa(RepositorioEtapa repositorioEtapa) {
        this.repositorioEtapa = repositorioEtapa;
    }

    public Long ejecutar(Etapa etapa) {
        validarExistenciaEtapaPrevia(etapa.getNombre());
        validarExistenciaEtapaPreviaCodigo(etapa.getCodigo());
        validarExistenciaEtapaId(etapa.getId());
        return this.repositorioEtapa.crear(etapa);
    }

    private void validarExistenciaEtapaPrevia(String nombre) {
        boolean existe = this.repositorioEtapa.existe(nombre);
        if (existe) {
            throw new ExcepcionEtapa(EL_NOMBRE_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaEtapaPreviaCodigo(String codigo) {
        boolean existe = this.repositorioEtapa.existeCodigo(codigo);
        if (existe) {
            throw new ExcepcionEtapa(EL_CODIGO_DEL_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaEtapaId(Long id) {
        boolean existe = this.repositorioEtapa.existeId(id);
        if (existe) {
            throw new ExcepcionEtapa(EL_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
