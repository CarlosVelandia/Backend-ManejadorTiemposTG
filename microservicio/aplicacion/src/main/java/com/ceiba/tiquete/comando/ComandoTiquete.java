package com.ceiba.tiquete.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoTiquete {

    private Long id;
    private Long idUsuario;
    private Long idParque;
    private String fechaCompra;
    private double valor;

}
