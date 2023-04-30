package com.ceiba.tiquete.testdatabuilder;

import com.ceiba.tiquete.comando.ComandoTiquete;

public class ComandoTiqueteTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idParque;
    private String fechaCompra;
    private double valor;

    public ComandoTiqueteTestDataBuilder() {
        this.id = 0l;
        this.idUsuario = 1l;
        this.idParque = 1l;
        this.fechaCompra= "2021-03-18";
        this.valor= 15000;
    }

    public ComandoTiqueteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoTiqueteTestDataBuilder conIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public ComandoTiqueteTestDataBuilder conIdParque(long idParque) {
        this.idParque = idParque;
        return this;
    }

    public ComandoTiqueteTestDataBuilder conFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public ComandoTiqueteTestDataBuilder conValor(double valor) {
        this.valor = valor;
        return this;
    }

    public ComandoTiquete build() {
        return new ComandoTiquete(id, idUsuario, idParque, fechaCompra, valor);
    }
}
