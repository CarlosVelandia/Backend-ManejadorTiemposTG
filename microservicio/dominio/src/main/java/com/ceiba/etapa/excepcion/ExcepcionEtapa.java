package com.ceiba.etapa.excepcion;

public class ExcepcionEtapa extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionEtapa(String message) {
        super(message);
    }
}
