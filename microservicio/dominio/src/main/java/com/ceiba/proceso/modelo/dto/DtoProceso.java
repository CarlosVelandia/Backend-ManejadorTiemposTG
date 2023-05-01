package com.ceiba.proceso.modelo.dto;

import com.ceiba.parque.modelo.dto.DtoParque;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoProceso {
    private Long id;
    private DtoUsuario idUsuario;
    private DtoParque idParque;
    private LocalDate fechaCompra;
    private double valor;
}
