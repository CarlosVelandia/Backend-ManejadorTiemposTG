package com.ceiba.etapa.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.etapa.excepcion.ExcepcionEtapa;
import com.ceiba.etapa.modelo.entidad.Etapa;
import com.ceiba.etapa.puerto.respositorio.RepositorioEtapa;
import com.ceiba.etapa.servicio.testdatabuilder.EtapaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioEliminarEtapaTest {

    private static final String El_ETAPA_NO_EXISTE = "El etapa no existe en el sistema";

    @Mock
    private RepositorioEtapa repositorioEtapa;

    @InjectMocks
    private ServicioEliminarEtapa servicioEliminarEtapa;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaEtapaTest() {
        //arrange
        Etapa etapa = new EtapaTestDataBuilder().build();
        Mockito.when(repositorioEtapa.existeId(etapa.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioEliminarEtapa.ejecutar(etapa.getId()), ExcepcionEtapa.class, El_ETAPA_NO_EXISTE);
    }

    @Test
    public void validarEliminarUsuarioTest() {
        // arrange
        Etapa etapa = new EtapaTestDataBuilder().build();
        Mockito.when(repositorioEtapa.existeId(etapa.getId())).thenReturn(true);
        // act - assert
        servicioEliminarEtapa.ejecutar(etapa.getId());
        // assert
        Mockito.verify(repositorioEtapa).eliminar(etapa.getId());
    }
}
