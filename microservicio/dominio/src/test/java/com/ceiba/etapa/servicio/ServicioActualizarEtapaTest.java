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

public class ServicioActualizarEtapaTest {

    private static final String EL_ETAPA_NO_EXISTE_EN_EL_SISTEMA = "El etapa no existe en el sistema";
    private static final String EL_CODIGO_ETAPA_YA_EXISTE_EN_EL_SISTEMA = "El codigo del etapa ya existe en el sistema";

    @Mock
    private RepositorioEtapa repositorioEtapa;

    @InjectMocks
    private ServicioActualizarEtapa servicioActualizarEtapa;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void validarExistenciaPreviaId() {
        //arrange
        Etapa etapa = new EtapaTestDataBuilder().build();
        Mockito.when(repositorioEtapa.existeId(etapa.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarEtapa.ejecutar(etapa), ExcepcionEtapa.class, EL_ETAPA_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarExistenciaPreviaCodigo() {
        //arrange
        Etapa etapa = new EtapaTestDataBuilder().build();
        Mockito.when(repositorioEtapa.existeId(etapa.getId())).thenReturn(true);
        Mockito.when(repositorioEtapa.existeExcluyendoId(etapa.getId(), etapa.getCodigo())).thenReturn(true);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarEtapa.ejecutar(etapa), ExcepcionEtapa.class, EL_CODIGO_ETAPA_YA_EXISTE_EN_EL_SISTEMA);
    }


    @Test
    public void validarActualizarEtapaTest() {
        // arrange
        Etapa etapa = new EtapaTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioEtapa.existeId(etapa.getId())).thenReturn(true);
        Mockito.when(repositorioEtapa.existeCodigo(etapa.getCodigo())).thenReturn(false);
        // act - assert
        servicioActualizarEtapa.ejecutar(etapa);
        // assert
        Mockito.verify(repositorioEtapa).actualizar(etapa);
    }

}
