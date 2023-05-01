package com.ceiba.proceso.controlador;

import com.ceiba.proceso.consulta.ManejadorListarProcesos;
import com.ceiba.proceso.modelo.dto.DtoProceso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/procesos")
@Api(tags = {"Controlador consulta proceso"})
public class ConsultaControladorProceso {

    private final ManejadorListarProcesos manejadorListarProcesos;

    public ConsultaControladorProceso(ManejadorListarProcesos manejadorListarProcesos) {
        this.manejadorListarProcesos = manejadorListarProcesos;
    }

    @GetMapping
    @ApiOperation("Listar Procesos")
    public List<DtoProceso> listar() {
        return this.manejadorListarProcesos.ejecutar();
    }
}
