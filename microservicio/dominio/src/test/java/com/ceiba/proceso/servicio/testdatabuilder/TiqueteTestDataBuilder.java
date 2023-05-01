package com.ceiba.proceso.servicio.testdatabuilder;

import com.ceiba.proceso.modelo.entidad.Proceso;

public class ProcesoTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idParque;
    private String fechaCompra;
    private double valor;

    public ProcesoTestDataBuilder() {

        this.id = 0l;
        this.idUsuario = 1l;
        this.idParque = 1l;
        this.fechaCompra = "2021-10-03";

    }

    public ProcesoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProcesoTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ProcesoTestDataBuilder conIdParque(Long idParque) {
        this.idParque = idParque;
        return this;
    }

    public ProcesoTestDataBuilder conFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public ProcesoTestDataBuilder conValor(double valor) {
        this.valor = valor;
        return this;
    }

    public Proceso build() {
        return new Proceso(id, idUsuario, idParque, fechaCompra, valor);
    }
}
