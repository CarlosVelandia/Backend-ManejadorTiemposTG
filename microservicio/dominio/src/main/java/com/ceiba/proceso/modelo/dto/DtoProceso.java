package com.ceiba.proceso.modelo.dto;

import com.ceiba.etapa.modelo.dto.DtoEtapa;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoProceso {
    private Long id;
    private DtoUsuario idUsuario;
    private DtoEtapa idEtapa;
    private LocalDate fechaCompra;
    private double valor;
}
