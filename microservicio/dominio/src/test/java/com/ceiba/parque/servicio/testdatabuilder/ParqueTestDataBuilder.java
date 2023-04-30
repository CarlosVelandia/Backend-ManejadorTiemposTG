package com.ceiba.parque.servicio.testdatabuilder;

import com.ceiba.parque.modelo.entidad.Parque;

public class ParqueTestDataBuilder {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;


    public ParqueTestDataBuilder() {
        this.id = 1l;
        this.nombre = "Retro";
        this.codigo = "63790";
        this.direccion = "Calle 22 # 15 - 56";
        this.telefono = "2273265";
    }

    public ParqueTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ParqueTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ParqueTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ParqueTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ParqueTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Parque build() {
        return new Parque(id, nombre, codigo, direccion, telefono);
    }
}
