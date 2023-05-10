package com.ceiba.etapa.servicio.testdatabuilder;

import com.ceiba.etapa.modelo.entidad.Etapa;

public class EtapaTestDataBuilder {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;


    public EtapaTestDataBuilder() {
        this.id = 1l;
        this.nombre = "Retro";
        this.codigo = "63790";
        this.direccion = "Calle 22 # 15 - 56";
        this.telefono = "2273265";
    }

    public EtapaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public EtapaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public EtapaTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public EtapaTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public EtapaTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Etapa build() {
        return new Etapa(id, nombre, codigo, direccion, telefono);
    }
}
