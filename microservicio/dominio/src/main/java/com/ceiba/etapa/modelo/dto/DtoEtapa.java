package com.ceiba.etapa.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoEtapa {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;
}
