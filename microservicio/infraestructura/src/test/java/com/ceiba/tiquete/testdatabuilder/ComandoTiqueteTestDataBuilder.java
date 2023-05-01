package com.ceiba.proceso.testdatabuilder;

import com.ceiba.proceso.comando.ComandoProceso;

public class ComandoProcesoTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idParque;
    private String fechaCompra;
    private double valor;

    public ComandoProcesoTestDataBuilder() {
        this.id = 0l;
        this.idUsuario = 1l;
        this.idParque = 1l;
        this.fechaCompra= "2021-03-18";
        this.valor= 15000;
    }

    public ComandoProcesoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoProcesoTestDataBuilder conIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ComandoProcesoTestDataBuilder conIdParque(long idParque) {
        this.idParque = idParque;
        return this;
    }

    public ComandoProcesoTestDataBuilder conFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public ComandoProcesoTestDataBuilder conValor(double valor) {
        this.valor = valor;
        return this;
    }

    public ComandoProceso build() {
        return new ComandoProceso(id, idUsuario, idParque, fechaCompra, valor);
    }
}
