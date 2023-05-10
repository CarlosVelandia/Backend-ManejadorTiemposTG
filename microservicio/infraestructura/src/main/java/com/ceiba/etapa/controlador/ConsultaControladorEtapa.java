package com.ceiba.etapa.controlador;

import com.ceiba.etapa.consulta.ManejadorListarEtapas;
import com.ceiba.etapa.modelo.dto.DtoEtapa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/etapas")
@Api(tags = {"Controlador consulta etapa"})
public class ConsultaControladorEtapa {

    private final ManejadorListarEtapas manejadorListarEtapas;

    public ConsultaControladorEtapa(ManejadorListarEtapas manejadorListarEtapas) {
        this.manejadorListarEtapas = manejadorListarEtapas;
    }

    @GetMapping
    @ApiOperation("Listar Etapas")
    public List<DtoEtapa> listar() {
        return this.manejadorListarEtapas.ejecutar();
    }
}
