package com.ceiba.parque.servicio;

import com.ceiba.parque.excepcion.ExcepcionParque;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioCrearParque {

    private static final String EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El parque ya existe en el sistema";
    private static final String EL_NOMBRE_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El nombre del parque ya existe en el sistema";
    private static final String EL_CODIGO_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El codigo del parque ya existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioCrearParque(RepositorioParque repositorioParque) {
        this.repositorioParque = repositorioParque;
    }

    public Long ejecutar(Parque parque) {
        validarExistenciaParquePrevia(parque.getNombre());
        validarExistenciaParquePreviaCodigo(parque.getCodigo());
        validarExistenciaParqueId(parque.getId());
        return this.repositorioParque.crear(parque);
    }

    private void validarExistenciaParquePrevia(String nombre) {
        boolean existe = this.repositorioParque.existe(nombre);
        if (existe) {
            throw new ExcepcionParque(EL_NOMBRE_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaParquePreviaCodigo(String codigo) {
        boolean existe = this.repositorioParque.existeCodigo(codigo);
        if (existe) {
            throw new ExcepcionParque(EL_CODIGO_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaParqueId(Long id) {
        boolean existe = this.repositorioParque.existeId(id);
        if (existe) {
            throw new ExcepcionParque(EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
