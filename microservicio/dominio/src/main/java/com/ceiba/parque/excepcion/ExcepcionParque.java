package com.ceiba.parque.excepcion;

public class ExcepcionParque extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionParque(String message) {
        super(message);
    }
}
