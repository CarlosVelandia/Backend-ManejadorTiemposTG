package com.ceiba.parque.servicio;

import com.ceiba.parque.excepcion.ExcepcionParque;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioActualizarParque {

    private static final String EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA = "El parque no existe en el sistema";
    private static final String EL_CODIGO_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El codigo del parque ya existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioActualizarParque(RepositorioParque repositorioParque) {
        this.repositorioParque = repositorioParque;
    }

    public void ejecutar(Parque parque) {
        validarExistenciaPreviaParque(parque.getId());
        validarExistenciaPreviaCodigo(parque.getId(),parque.getCodigo());
        this.repositorioParque.actualizar(parque);
    }

    private void validarExistenciaPreviaParque(Long id) {
        boolean existe = this.repositorioParque.existeId(id);
        if (!existe) {
            throw new ExcepcionParque(EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaCodigo(Long id, String codigo) {
        boolean existe = this.repositorioParque.existeExcluyendoId(id,codigo);
        if (existe) {
            throw new ExcepcionParque(EL_CODIGO_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
