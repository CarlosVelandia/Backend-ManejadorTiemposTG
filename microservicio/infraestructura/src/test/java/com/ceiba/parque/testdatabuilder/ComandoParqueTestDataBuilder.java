package com.ceiba.parque.testdatabuilder;

import com.ceiba.parque.comando.ComandoParque;

public class ComandoParqueTestDataBuilder {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;

    public ComandoParqueTestDataBuilder() {
        this.id = 0l;
        this.nombre = "parque";
        this.codigo = "1663790";
        this.direccion= "Calle test # 1 - 23";
        this.telefono= "123456";
    }

    public ComandoParqueTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoParqueTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoParqueTestDataBuilder conCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ComandoParqueTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public ComandoParqueTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ComandoParque build() {
        return new ComandoParque(id, nombre, codigo, direccion, telefono);
    }
}
