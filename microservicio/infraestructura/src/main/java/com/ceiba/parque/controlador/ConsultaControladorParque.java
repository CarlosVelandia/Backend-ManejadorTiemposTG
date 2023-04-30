package com.ceiba.parque.controlador;

import com.ceiba.parque.consulta.ManejadorListarParques;
import com.ceiba.parque.modelo.dto.DtoParque;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parques")
@Api(tags = {"Controlador consulta parque"})
public class ConsultaControladorParque {

    private final ManejadorListarParques manejadorListarParques;

    public ConsultaControladorParque(ManejadorListarParques manejadorListarParques) {
        this.manejadorListarParques = manejadorListarParques;
    }

    @GetMapping
    @ApiOperation("Listar Parques")
    public List<DtoParque> listar() {
        return this.manejadorListarParques.ejecutar();
    }
}
