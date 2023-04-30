package com.ceiba.tiquete.servicio.testdatabuilder;

import com.ceiba.tiquete.modelo.entidad.Tiquete;

public class TiqueteTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idParque;
    private String fechaCompra;
    private double valor;

    public TiqueteTestDataBuilder() {

        this.id = 0l;
        this.idUsuario = 1l;
        this.idParque = 1l;
        this.fechaCompra = "2021-10-03";

    }

    public TiqueteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public TiqueteTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }

    public TiqueteTestDataBuilder conIdParque(Long idParque) {
        this.idParque = idParque;
        return this;
    }

    public TiqueteTestDataBuilder conFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
        return this;
    }

    public TiqueteTestDataBuilder conValor(double valor) {
        this.valor = valor;
        return this;
    }

    public Tiquete build() {
        return new Tiquete(id, idUsuario, idParque, fechaCompra, valor);
    }
}
