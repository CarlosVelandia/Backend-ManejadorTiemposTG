package com.ceiba.etapa.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEtapa {

    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;
}
