package com.ceiba.proceso.excepcion;

public class ExcepcionProceso extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionProceso(String message) {
        super(message);
    }
}
