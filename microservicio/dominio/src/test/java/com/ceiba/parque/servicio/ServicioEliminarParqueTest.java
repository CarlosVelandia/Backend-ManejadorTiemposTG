package com.ceiba.parque.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.parque.excepcion.ExcepcionParque;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.parque.servicio.testdatabuilder.ParqueTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioEliminarParqueTest {

    private static final String El_PARQUE_NO_EXISTE = "El parque no existe en el sistema";

    @Mock
    private RepositorioParque repositorioParque;

    @InjectMocks
    private ServicioEliminarParque servicioEliminarParque;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaParqueTest() {
        //arrange
        Parque parque = new ParqueTestDataBuilder().build();
        Mockito.when(repositorioParque.existeId(parque.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioEliminarParque.ejecutar(parque.getId()), ExcepcionParque.class, El_PARQUE_NO_EXISTE);
    }

    @Test
    public void validarEliminarUsuarioTest() {
        // arrange
        Parque parque = new ParqueTestDataBuilder().build();
        Mockito.when(repositorioParque.existeId(parque.getId())).thenReturn(true);
        // act - assert
        servicioEliminarParque.ejecutar(parque.getId());
        // assert
        Mockito.verify(repositorioParque).eliminar(parque.getId());
    }
}
