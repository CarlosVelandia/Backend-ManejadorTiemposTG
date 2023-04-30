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

public class ServicioActualizarParqueTest {

    private static final String EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA = "El parque no existe en el sistema";
    private static final String EL_CODIGO_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El codigo del parque ya existe en el sistema";

    @Mock
    private RepositorioParque repositorioParque;

    @InjectMocks
    private ServicioActualizarParque servicioActualizarParque;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void validarExistenciaPreviaId() {
        //arrange
        Parque parque = new ParqueTestDataBuilder().build();
        Mockito.when(repositorioParque.existeId(parque.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarParque.ejecutar(parque), ExcepcionParque.class, EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExistenciaPreviaCodigo() {
        //arrange
        Parque parque = new ParqueTestDataBuilder().build();
        Mockito.when(repositorioParque.existeId(parque.getId())).thenReturn(true);
        Mockito.when(repositorioParque.existeExcluyendoId(parque.getId(), parque.getCodigo())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarParque.ejecutar(parque), ExcepcionParque.class, EL_CODIGO_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
    }


    @Test
    public void validarActualizarParqueTest() {
        // arrange
        Parque parque = new ParqueTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioParque.existeId(parque.getId())).thenReturn(true);
        Mockito.when(repositorioParque.existeCodigo(parque.getCodigo())).thenReturn(false);
        // act - assert
        servicioActualizarParque.ejecutar(parque);
        // assert
        Mockito.verify(repositorioParque).actualizar(parque);
    }

}
