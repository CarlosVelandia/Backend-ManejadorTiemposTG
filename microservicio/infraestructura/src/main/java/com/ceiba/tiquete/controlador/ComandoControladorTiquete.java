package com.ceiba.tiquete.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.tiquete.comando.ComandoTiquete;
import com.ceiba.tiquete.comando.manejador.ManejadorActualizarTiquete;
import com.ceiba.tiquete.comando.manejador.ManejadorCrearTiquete;
import com.ceiba.tiquete.comando.manejador.ManejadorEliminarTiquete;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tiquetes")
@Api(tags = {"Controlador comando tiquete"})
public class ComandoControladorTiquete {

    private final ManejadorCrearTiquete manejadorCrearTiquete;
    private final ManejadorActualizarTiquete manejadorActualizarTiquete;
    private final ManejadorEliminarTiquete manejadorEliminarTiquete;

    @Autowired
    public ComandoControladorTiquete(ManejadorCrearTiquete manejadorCrearTiquete, ManejadorActualizarTiquete manejadorActualizarTiquete, ManejadorEliminarTiquete manejadorEliminarTiquete) {
        this.manejadorCrearTiquete = manejadorCrearTiquete;
        this.manejadorActualizarTiquete = manejadorActualizarTiquete;
        this.manejadorEliminarTiquete = manejadorEliminarTiquete;
    }

    @PostMapping
    @ApiOperation("Crear Tiquete")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoTiquete comandoTiquete) {
        return manejadorCrearTiquete.ejecutar(comandoTiquete);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Tiquete")
    public void actualizar(@RequestBody ComandoTiquete comandoTiquete, @PathVariable Long id) {
        comandoTiquete.setId(id);
        manejadorActualizarTiquete.ejecutar(comandoTiquete);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Tiquete")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarTiquete.ejecutar(id);
    }
}
