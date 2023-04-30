package com.ceiba.tiquete.excepcion;

public class ExcepcionTiquete extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionTiquete(String message) {
        super(message);
    }
}
