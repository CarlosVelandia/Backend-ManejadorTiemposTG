package com.ceiba.etapa.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.etapa.comando.ComandoEtapa;
import com.ceiba.etapa.comando.manejador.ManejadorActualizarEtapa;
import com.ceiba.etapa.comando.manejador.ManejadorCrearEtapa;
import com.ceiba.etapa.comando.manejador.ManejadorEliminarEtapa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/etapas")
@Api(tags = {"Controlador comando etapa"})
public class ComandoControladorEtapa {

    private final ManejadorCrearEtapa manejadorCrearEtapa;
    private final ManejadorActualizarEtapa manejadorActualizarEtapa;
    private final ManejadorEliminarEtapa manejadorEliminarEtapa;

    @Autowired
    public ComandoControladorEtapa(ManejadorCrearEtapa manejadorCrearEtapa, ManejadorActualizarEtapa manejadorActualizarEtapa, ManejadorEliminarEtapa manejadorEliminarEtapa) {
        this.manejadorCrearEtapa = manejadorCrearEtapa;
        this.manejadorActualizarEtapa = manejadorActualizarEtapa;
        this.manejadorEliminarEtapa = manejadorEliminarEtapa;
    }

    @PostMapping
    @ApiOperation("Crear Etapa")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEtapa comandoEtapa) {
        return manejadorCrearEtapa.ejecutar(comandoEtapa);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Etapa")
    public void actualizar(@RequestBody ComandoEtapa comandoEtapa, @PathVariable Long id) {
        comandoEtapa.setId(id);
        manejadorActualizarEtapa.ejecutar(comandoEtapa);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Etapa")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarEtapa.ejecutar(id);
    }

}
