package com.ceiba.proceso.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.proceso.comando.ComandoProceso;
import com.ceiba.proceso.comando.manejador.ManejadorActualizarProceso;
import com.ceiba.proceso.comando.manejador.ManejadorCrearProceso;
import com.ceiba.proceso.comando.manejador.ManejadorEliminarProceso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesos")
@Api(tags = {"Controlador comando proceso"})
public class ComandoControladorProceso {

    private final ManejadorCrearProceso manejadorCrearProceso;
    private final ManejadorActualizarProceso manejadorActualizarProceso;
    private final ManejadorEliminarProceso manejadorEliminarProceso;

    @Autowired
    public ComandoControladorProceso(ManejadorCrearProceso manejadorCrearProceso, ManejadorActualizarProceso manejadorActualizarProceso, ManejadorEliminarProceso manejadorEliminarProceso) {
        this.manejadorCrearProceso = manejadorCrearProceso;
        this.manejadorActualizarProceso = manejadorActualizarProceso;
        this.manejadorEliminarProceso = manejadorEliminarProceso;
    }

    @PostMapping
    @ApiOperation("Crear Proceso")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProceso comandoProceso) {
        return manejadorCrearProceso.ejecutar(comandoProceso);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Proceso")
    public void actualizar(@RequestBody ComandoProceso comandoProceso, @PathVariable Long id) {
        comandoProceso.setId(id);
        manejadorActualizarProceso.ejecutar(comandoProceso);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Proceso")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProceso.ejecutar(id);
    }
}
