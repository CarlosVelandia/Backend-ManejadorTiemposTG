package com.ceiba.tiquete.controlador;

import com.ceiba.tiquete.consulta.ManejadorListarTiquetes;
import com.ceiba.tiquete.modelo.dto.DtoTiquete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tiquetes")
@Api(tags = {"Controlador consulta tiquete"})
public class ConsultaControladorTiquete {

    private final ManejadorListarTiquetes manejadorListarTiquetes;

    public ConsultaControladorTiquete(ManejadorListarTiquetes manejadorListarTiquetes) {
        this.manejadorListarTiquetes = manejadorListarTiquetes;
    }

    @GetMapping
    @ApiOperation("Listar Tiquetes")
    public List<DtoTiquete> listar() {
        return this.manejadorListarTiquetes.ejecutar();
    }
}
