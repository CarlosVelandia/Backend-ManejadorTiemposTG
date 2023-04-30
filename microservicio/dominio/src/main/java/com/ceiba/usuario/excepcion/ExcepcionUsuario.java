package com.ceiba.usuario.excepcion;

public class ExcepcionUsuario extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionUsuario(String message) {
        super(message);
    }
}
