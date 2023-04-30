package com.ceiba.parque.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.parque.comando.ComandoParque;
import com.ceiba.parque.comando.manejador.ManejadorActualizarParque;
import com.ceiba.parque.comando.manejador.ManejadorCrearParque;
import com.ceiba.parque.comando.manejador.ManejadorEliminarParque;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parques")
@Api(tags = {"Controlador comando parque"})
public class ComandoControladorParque {

    private final ManejadorCrearParque manejadorCrearParque;
    private final ManejadorActualizarParque manejadorActualizarParque;
    private final ManejadorEliminarParque manejadorEliminarParque;

    @Autowired
    public ComandoControladorParque(ManejadorCrearParque manejadorCrearParque, ManejadorActualizarParque manejadorActualizarParque, ManejadorEliminarParque manejadorEliminarParque) {
        this.manejadorCrearParque = manejadorCrearParque;
        this.manejadorActualizarParque = manejadorActualizarParque;
        this.manejadorEliminarParque = manejadorEliminarParque;
    }

    @PostMapping
    @ApiOperation("Crear Parque")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoParque comandoParque) {
        return manejadorCrearParque.ejecutar(comandoParque);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation("Actualizar Parque")
    public void actualizar(@RequestBody ComandoParque comandoParque, @PathVariable Long id) {
        comandoParque.setId(id);
        manejadorActualizarParque.ejecutar(comandoParque);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Eliminar Parque")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarParque.ejecutar(id);
    }

}
