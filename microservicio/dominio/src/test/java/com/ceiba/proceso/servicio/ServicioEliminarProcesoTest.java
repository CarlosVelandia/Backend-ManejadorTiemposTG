package com.ceiba.proceso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.proceso.excepcion.ExcepcionProceso;
import com.ceiba.proceso.modelo.entidad.Proceso;
import com.ceiba.proceso.puerto.repositorio.RepositorioProceso;
import com.ceiba.proceso.servicio.testdatabuilder.ProcesoTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioEliminarProcesoTest {

    private static final String EL_PROCESO_NO_EXISTE = "El proceso no existe en el sistema";

    @Mock
    private RepositorioProceso repositorioProceso;

    @InjectMocks
    private ServicioEliminarProceso servicioEliminarProceso;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaProcesoTest() {
        //arrange
        Proceso proceso = new ProcesoTestDataBuilder().build();
        Mockito.when(repositorioProceso.existeId(proceso.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioEliminarProceso.ejecutar(proceso.getId()), ExcepcionProceso.class, EL_PROCESO_NO_EXISTE);
    }

    @Test
    public void validarEliminarUsuarioTest() {
        // arrange
        Proceso proceso = new ProcesoTestDataBuilder().build();
        Mockito.when(repositorioProceso.existeId(proceso.getId())).thenReturn(true);
        // act - assert
        servicioEliminarProceso.ejecutar(proceso.getId());
        // assert
        Mockito.verify(repositorioProceso).eliminar(proceso.getId());
    }
}
