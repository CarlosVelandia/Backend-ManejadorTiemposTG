package com.ceiba.etapa.testdatabuilder;

import com.ceiba.etapa.comando.ComandoEtapa;

public class ComandoEtapaTestDataBuilder {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;

    public ComandoEtapaTestDataBuilder() {
        this.id = 0l;
        this.nombre = "etapa";
        this.codigo = "1663790";
        this.direccion= "Calle test # 1 - 23";
        this.telefono= "123456";
    }

    public ComandoEtapaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoEtapaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoEtapaTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ComandoEtapaTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ComandoEtapaTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ComandoEtapa build() {
        return new ComandoEtapa(id, nombre, codigo, direccion, telefono);
    }
}
