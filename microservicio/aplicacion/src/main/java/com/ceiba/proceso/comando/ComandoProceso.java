package com.ceiba.proceso.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProceso {

    private Long id;
    private Long idUsuario;
    private Long idEtapa;
    private String fechaCompra;
    private double valor;

}
