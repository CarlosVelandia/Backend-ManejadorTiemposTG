package com.ceiba.usuario.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String cedula;

    public UsuarioTestDataBuilder() {
        this.id = 0l;
        this.nombre = "Manoloo";
        this.cedula = "1115081333";
    }

    public UsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public UsuarioTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public Usuario build() {
        return new Usuario(id, nombre, cedula);
    }
}
